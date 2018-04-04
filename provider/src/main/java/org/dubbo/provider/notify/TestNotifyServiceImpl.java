package org.dubbo.provider.notify;

import org.dubbo.common.TestNotifyService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 18-4-4.
 */
@Service("testNotifyService")
public class TestNotifyServiceImpl implements TestNotifyService {
    @Override
    public String hello(String name) {
        return name + "notify result";
    }
}
