package org.multitest.needer;

import org.multitest.dubbo.TestDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        TestDubboService demoService = (TestDubboService)context.getBean("dubboSvr"); // 获取远程服务代理
        String hello = demoService.hello("world"); // 执行远程方法
        System.out.println(hello);
        System.in.read();
    }
}
