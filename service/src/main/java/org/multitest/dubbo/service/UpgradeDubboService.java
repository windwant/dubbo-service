package org.multitest.dubbo.service;

import java.io.InputStream;

/**
 * UpgradeDubboService
 */

public interface UpgradeDubboService {

    String hello(String name);

    InputStream download(String path);
}
