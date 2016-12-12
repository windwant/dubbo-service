package org.multitest.dubbo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multitest.dubbo.service.UpgradeDubboService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * UpgradeDubboServiceImpl
 */
@Service("downSvr")
public class UpgradeDubboServiceImpl implements UpgradeDubboService {
    private static final Logger logger = LogManager.getLogger(UpgradeDubboServiceImpl.class);

    @Override
    public String hello(String name) {
        logger.info(name + " come to say hello");
        return name + " say hello!";
    }

    @Override
    public InputStream download(String path) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            logger.info("download reqest path: {}", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
