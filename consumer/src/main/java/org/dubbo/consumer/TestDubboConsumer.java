package org.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.dubbo.common.HelloDubboService;
import org.dubbo.common.StubDubboService;
import org.dubbo.common.TestNotifyService;
import org.dubbo.common.UpgradeDubboService;
import org.dubbo.common.callback.CallbackListener;
import org.dubbo.common.callback.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * TestDubboConsumer
 */
public class TestDubboConsumer {
    private static ClassPathXmlApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        context.registerShutdownHook();
    }


    public static void consume() throws ExecutionException, InterruptedException {
        HelloDubboService helloSvrDev = (HelloDubboService)context.getBean("helloSvrDev"); // 获取远程服务代理
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RpcContext.getContext().setAttachment("index", String.valueOf(i));//隐式参数
            String hello = helloSvrDev.hello("world-message"); // 执行远程方法
            System.out.println(hello);
            Future future =  RpcContext.getContext().getFuture();
            futureList.add(future);
        }
        futureList.forEach(future -> {
            try {
                System.out.println(future != null ? future.get() : "Null"); //异步执行获取结果
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * 文件下载
     * @param srcPath
     * @param desPath
     */
    public static void download(String srcPath, String desPath){
        UpgradeDubboService downloadSvrDev = (UpgradeDubboService)context.getBean("downloadSvrDev"); // 获取远程服务代理
        FileOutputStream fo = null;
        InputStream fi = null;
        try {
            fo = new FileOutputStream(desPath);
            fi = downloadSvrDev.download(srcPath);
            byte[] b = new byte[1024];
            while (fi.read(b) > -1) {
                fo.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fi != null) {
                    fi.close();
                }
                if(fo != null) {
                    fo.flush();
                    fo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("upgrade over");
    }

    /**
     * 回声测试
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void echo() throws ExecutionException, InterruptedException {
        HelloDubboService helloSvrDev = (HelloDubboService)context.getBean("helloSvrDev"); // 获取远程服务代理
        EchoService echo = (EchoService) helloSvrDev;
        echo.$echo("OK");
        Future future =  RpcContext.getContext().getFuture();
        System.out.println(future.get());
    }

    /**
     * dubbo callback
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws IOException
     */
    public static void consumeWithCallBack() throws ExecutionException, InterruptedException, IOException {
        CallbackService callbackService = (CallbackService) context.getBean("callbackService");
        callbackService.addListener("foo.bar", new CallbackListener() {
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
        System.in.read();
    }

    /**
     * 事件通知
     */
    public static void consumeWithNotify(){
        TestNotifyService testNotifyService = (TestNotifyService) context.getBean("testNotifyService");
        testNotifyService.hello("notify..");
    }

    /**
     * 本地存根 stub
     */
    public static void consumeWithStub(){
        StubDubboService stubDubboService = (StubDubboService) context.getBean("stubDubboService");
        System.out.println(stubDubboService.hello("stub.."));
    }

    /**
     * mock
     */
    public static void consumeWithMock(){
        StubDubboService stubDubboService = (StubDubboService) context.getBean("stubDubboService");
        System.out.println(stubDubboService.testMock("mock.."));
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
//        TestDubboConsumer.download("F:\\intel.zip", "F:\\afdfasdfa.rar");
//        TestDubboConsumer.consume();
//        echo();
//        consumeWithCallBack();
//        consumeWithNotify();
//        consumeWithStub();
        consumeWithMock();
    }
}
