package org.dubbo.consumer.stub;

import org.dubbo.common.StubDubboService;

/**
 * Created by Administrator on 18-4-4.
 */
public class StubDubboServiceStub implements StubDubboService {

    private StubDubboService stubDubboService;

    public StubDubboServiceStub(StubDubboService stubDubboService){
        this.stubDubboService = stubDubboService;
    }

    public String hello(String name) {
        System.out.println("sub opt helloDubboService hello: " + name);
        return stubDubboService.hello(name);
    }
}
