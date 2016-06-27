package org.multitest.needer;

import org.multitest.dubbo.TestDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by aayongche on 2016/6/27.
 */
public class TestDubboConsumer {
    public void consume() throws IOException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        TestDubboService demoService = (TestDubboService)context.getBean("dubboSvr"); // 获取远程服务代理
        for (int i = 0; i < 10; i++) {
            String hello = demoService.hello("world-" + i); // 执行远程方法
            System.out.println(hello);
            Thread.sleep(1000);
        }
        System.in.read();
    }
}
