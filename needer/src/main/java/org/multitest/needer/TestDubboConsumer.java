package org.multitest.needer;

import org.multitest.dubbo.service.DownloadDubboService;
import org.multitest.dubbo.service.HelloDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TestDubboConsumer
 */
public class TestDubboConsumer {
    private static HelloDubboService helloSvr = null;
    private static DownloadDubboService downSvr = null;
    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        helloSvr = (HelloDubboService)context.getBean("helloSvr"); // 获取远程服务代理
        downSvr = (DownloadDubboService)context.getBean("downloadSvr"); // 获取远程服务代理
    }


    public static void consume(){
        for (int i = 0; i < 10; i++) {
            String hello = helloSvr.hello("world-" + i); // 执行远程方法
            System.out.println(hello);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void download(String srcPath, String desPath){
        FileOutputStream fo = null;
        InputStream fi = null;
        try {
            fo = new FileOutputStream(desPath);
            fi = downSvr.download(srcPath);
            byte[] b = new byte[1024];
            while (fi.read(b) != -1) {
                fo.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fi.close();
                fo.flush();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestDubboConsumer.download("F:\\phpmemcache.php", "F:\\aaaaaaaaaaa.php");
//        TestDubboConsumer.consume();
    }
}
