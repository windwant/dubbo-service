package org.multitest.dubbo.impl;

import org.multitest.dubbo.TestDubboService;
import org.springframework.stereotype.Service;

/**
 * Created by aayongche on 2016/6/25.
 */
@Service("dubboSvr")
public class TestDubboServiceImpl implements TestDubboService {
    @Override
    public String hello(String name) {
        return name + " say hello!";
    }
}
