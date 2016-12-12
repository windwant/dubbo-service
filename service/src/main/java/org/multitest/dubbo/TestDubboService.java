package org.multitest.dubbo;

import java.io.InputStream;

/**
 * TestDubboService
 */

public interface TestDubboService {

    String hello(String name);

    InputStream download(String path);
}
