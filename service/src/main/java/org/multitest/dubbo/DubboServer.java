package org.multitest.dubbo;

import com.alibaba.dubbo.container.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * DubboServer
 */
public class DubboServer implements Container {
    private static final Logger logger = LoggerFactory.getLogger(DubboServer.class);
    private ClassPathXmlApplicationContext context;

    @Override
    public void start(){
        context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        context.start();
        context.registerShutdownHook();
        logger.info("service start success");
    }

    @Override
    public void stop() {
        try {
            if (context != null) {
                context.stop();
                context.close();
                context = null;
            }
            logger.info("service stop success");
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
    }

    private static volatile boolean running = true;
    public static void main(String[] args) {
        try{
            Container container = new DubboServer();
            logger.info("Use container type(" + Arrays.toString(args) + ") to run dubbo serivce.");

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        container.stop();
                        logger.info("Dubbo " + container.getClass().getSimpleName() + " stopped!");
                    } catch (Throwable t) {
                        logger.error(t.getMessage(), t);
                    }
                    synchronized (DubboServer.class) {
                        running = false;
                        DubboServer.class.notify();
                    }
                }
            });

            container.start();
            logger.info("Dubbo " + container.getClass().getSimpleName() + " started!");
            System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " Dubbo service server started!");
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }
        synchronized (DubboServer.class) {
            while (running) {
                try {
                    DubboServer.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }
}
