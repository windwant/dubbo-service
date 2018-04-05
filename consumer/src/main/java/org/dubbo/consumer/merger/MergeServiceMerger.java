package org.dubbo.consumer.merger;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.cluster.Merger;

/**
 * 自定义 merger 配置META-INF/dubbo/com.alibaba.dubbo.rpc.cluster.Merger
 *  mymerger=org.dubbo.consumer.merger.MergeServiceMerger
 *
 * Created by Administrator on 18-4-4.
 */
public class MergeServiceMerger implements Merger<String> {

    @Override
    public String merge(String... items) {
        return StringUtils.join(items);
    }
}
