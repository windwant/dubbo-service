package org.dubbo.provider.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import org.dubbo.common.HelloDubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * HelloDubboServiceImpl
 */
@Service("helloSvr")
public class HelloDubboServiceImpl implements HelloDubboService {
    private static final Logger logger = LoggerFactory.getLogger(HelloDubboServiceImpl.class);
    @Override
    public String hello(String name) {
        logger.info("hello begin...");
        logger.info("host: ", RpcContext.getContext().getRemoteHost()); //host
        logger.info("param: {}", RpcContext.getContext().getArguments()); //参数
        logger.info("param: {}", RpcContext.getContext().getAttachments()); //隐式参数
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        logger.info("hello end!!!");
        return name + " say hello!";
    }
}
