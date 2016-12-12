package org.multitest.dubbo;

import com.google.common.util.concurrent.AbstractIdleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestServer
 */
@Deprecated
public class TestServer extends AbstractIdleService {
    private static final Logger logger = LoggerFactory.getLogger(TestServer.class);
    private ClassPathXmlApplicationContext context;

    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        context.start();
        context.registerShutdownHook();
        logger.info("service start success");
    }

    @Override
    protected void shutDown() throws Exception {
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

    public static void main(String[] args) {
        try {
            new TestServer().startUp();
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
