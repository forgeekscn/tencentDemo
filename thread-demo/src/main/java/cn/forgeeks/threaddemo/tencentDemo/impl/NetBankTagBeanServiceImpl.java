package cn.forgeeks.threaddemo.tencentDemo.impl;

import cn.forgeeks.threaddemo.tencentDemo.pojo.TagBeanResult;
import cn.forgeeks.threaddemo.tencentDemo.service.AbstractTagBeanService;

/**
 * 网银风控标签计算实现类
 */
public class NetBankTagBeanServiceImpl extends AbstractTagBeanService {
    @Override
    public TagBeanResult doGetTagValue(String tag) {
        return new TagBeanResult();
    }

    @Override
    public Boolean isParamValid() {
        String tag = getTag();
        System.out.println("Checking param ...");
        return true;
    }
}
