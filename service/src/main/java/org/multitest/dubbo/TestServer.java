package org.multitest.dubbo;

import com.google.common.util.concurrent.AbstractIdleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by aayongche on 2016/6/28.
 */
public class TestServer extends AbstractIdleService {
    private ClassPathXmlApplicationContext context;

    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        context.start();
        context.registerShutdownHook();
        System.out.println("service start success");
    }

    @Override
    protected void shutDown() throws Exception {
        context.stop();
        System.out.println("service stop success");
    }
}
