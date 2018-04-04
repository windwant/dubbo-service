package org.dubbo.consumer.notify;

/**
 * Created by Administrator on 18-4-4.
 */
public interface DownloadNotify {

    void onreturn(String res, String name);

    void onthrow(Throwable ex, String name);
}
