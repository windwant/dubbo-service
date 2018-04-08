package org.dubbo.consumer.listener;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 18-4-8.
 */
public class MyDubboExporterListener implements ExporterListener {

    private static final Logger logger = LoggerFactory.getLogger(MyDubboExporterListener.class);

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        logger.info("exported exporter: {}", exporter.toString());
    }

    @Override
    public void unexported(Exporter<?> exporter) {
        logger.info("unexported exporter: {}", exporter.toString());
    }
}
