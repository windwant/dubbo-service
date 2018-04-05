package org.dubbo.provider.merge;

import org.dubbo.common.merge.MergeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 18-4-4.
 */
@Service("mergef")
public class MergeServiceImplF implements MergeService {
    @Override
    public List<String> helloList(String name) {
        List<String> result = new ArrayList();
        result.add("mergeF: " + name + " | ");
        return result;
    }

    @Override
    public String helloString(String name) {
        return "mergeF: " + name + " | ";
    }
}
