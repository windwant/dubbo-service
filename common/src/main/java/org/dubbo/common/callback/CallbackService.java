package org.dubbo.common.callback;

/**
 * Created by Administrator on 2018/1/26.
 */
/**
 * CallbackService
 */
public interface CallbackService {

    void addListener(String key, CallbackListener listener);

}