package org.dubbo.consumer.stub;

import org.dubbo.common.StubDubboService;

/**
 * StubProxyFactoryWrapper
 *     getProxy
 *         invoker.getUrl().getParameter("stub" url部分被编码，获取不到stub
 * Created by Administrator on 18-4-4.
 */
public class StubDubboServiceStub implements StubDubboService {

    private StubDubboService localStubDubboService;

    public StubDubboServiceStub(StubDubboService stubDubboService){
        this.localStubDubboService = stubDubboService;
    }

    public String hello(String name) {
        System.out.println("sub opt helloDubboService hello: " + name);
        return localStubDubboService.hello(name);
    }

    @Override
    public String testMock(String name) {
        return localStubDubboService.testMock(name);
    }
}
