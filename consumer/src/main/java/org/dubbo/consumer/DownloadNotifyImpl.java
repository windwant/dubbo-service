package org.dubbo.consumer;

/**
 * Created by Administrator on 18-4-4.
 */
public class DownloadNotifyImpl implements DownloadNotify{

    public void onreturn(String res, String name) {
        System.out.println("返回值：" + res);
        System.out.println("参数：" + name);
    }

    public void onthrow(Throwable ex, String name) {
        System.out.println("异常：" + ex.getMessage());
        System.out.println("异常参数：" + name);
    }
}
