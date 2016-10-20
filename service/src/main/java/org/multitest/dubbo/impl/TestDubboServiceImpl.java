package org.multitest.dubbo.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multitest.dubbo.TestDubboService;
import org.springframework.stereotype.Service;

/**
 * TestDubboServiceImpl
 */
@Service("dubboSvr")
public class TestDubboServiceImpl implements TestDubboService {
    private static final Logger logger = LogManager.getLogger(TestDubboServiceImpl.class);
    @Override
    public String hello(String name) {
        logger.info(name + " come to say hello");
        return name + " say hello!";
    }
}
