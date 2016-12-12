package org.multitest.dubbo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multitest.dubbo.service.HelloDubboService;
import org.springframework.stereotype.Service;

/**
 * HelloDubboServiceImpl
 */
@Service("helloSvr")
public class HelloDubboServiceImpl implements HelloDubboService {
    private static final Logger logger = LogManager.getLogger(HelloDubboServiceImpl.class);
    @Override
    public String hello(String name) {
        logger.info(name + " come to say hello");
        return name + " say hello!";
    }
}
