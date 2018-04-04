package org.dubbo.provider.service.impl;

import org.dubbo.common.UpgradeDubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * UpgradeDubboServiceImpl
 */
@Service("downSvr")
public class UpgradeDubboServiceImpl implements UpgradeDubboService {
    private static final Logger logger = LoggerFactory.getLogger(UpgradeDubboServiceImpl.class);

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
