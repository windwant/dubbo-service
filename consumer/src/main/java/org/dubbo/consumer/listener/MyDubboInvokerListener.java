package org.dubbo.consumer.listener;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 18-4-8.
 */
public class MyDubboInvokerListener implements InvokerListener {

    private static final Logger logger = LoggerFactory.getLogger(MyDubboInvokerListener.class);

    public void referred(Invoker<?> invoker) throws RpcException {
        logger.info("referred invoker: {}", invoker.toString());
    }

    public void destroyed(Invoker<?> invoker) {
        logger.info("destroyed invoker: {}", invoker.toString());
    }
}
