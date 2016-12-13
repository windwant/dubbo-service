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
        logger.info(name + " come to say hello");
        return name + " say hello!";
    }
}
