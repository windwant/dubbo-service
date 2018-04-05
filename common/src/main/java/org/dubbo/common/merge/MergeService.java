package org.dubbo.common.merge;

import java.util.List;

/**
 * Created by Administrator on 18-4-4.
 */
public interface MergeService {

    List<String> helloList(String name);

    String helloString(String name);
}
