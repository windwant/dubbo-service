package org.multitest.needer;

import org.multitest.dubbo.TestDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TestDubboConsumer
 */
public class TestDubboConsumer {
    TestDubboService demoService = null;
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        demoService = (TestDubboService)context.getBean("dubboSvr"); // 获取远程服务代理
    }


    public void consume() throws IOException, InterruptedException {
        init();
        for (int i = 0; i < 10; i++) {
            String hello = demoService.hello("world-" + i); // 执行远程方法
            System.out.println(hello);
            Thread.sleep(1000);
        }
        System.in.read();
    }

    public void download(String srcPath, String desPath){
        init();
        FileOutputStream fo = null;
        InputStream fi = null;
        try {
            fo = new FileOutputStream(desPath);
            fi = demoService.download(srcPath);
            byte[] b = new byte[1024];
            while (fi.read(b) != -1) {
                fo.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        new TestDubboConsumer().download("F:\\unionpay.rar", "F:\\uuuu.rar");
    }
}
