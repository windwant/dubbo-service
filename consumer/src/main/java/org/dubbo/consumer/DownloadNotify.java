package org.dubbo.consumer;

/**
 * Created by Administrator on 18-4-4.
 */
public class DownloadNotify {

    public void onreturn(Object res, Object... args) {
        System.out.println("返回值：" + res);
        for (Object object : args) {
            System.out.println("参数：" + object);
        }
    }

    public void onthrow(Throwable ex, Object... args) {
        System.out.println("异常：" + ex.getMessage());
        for (Object object : args) {
            System.out.println("异常参数：" + object);
        }
    }
}
