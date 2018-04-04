package org.dubbo.common.mock;

import org.dubbo.common.StubDubboService;

/**
 * Created by Administrator on 18-4-4.
 */
public class StubDubboServiceMock implements StubDubboService {
    @Override
    public String hello(String name) {
        return "mock " + name;
    }

    @Override
    public String testMock(String name) {
        return "mock down";
    }
}
