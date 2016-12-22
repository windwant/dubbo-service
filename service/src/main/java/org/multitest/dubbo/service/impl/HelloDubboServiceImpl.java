package org.multitest.dubbo.service.impl;

import org.multitest.dubbo.service.HelloDubboService;
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        logger.info("hello end!!!");
        return name + " say hello!";
    }
}
