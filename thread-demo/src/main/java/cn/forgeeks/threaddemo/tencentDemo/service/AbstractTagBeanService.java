package cn.forgeeks.threaddemo.tencentDemo.service;

import cn.forgeeks.threaddemo.tencentDemo.pojo.TagBeanResult;

/**
 * 标签计算服务抽象类
 */
public abstract class AbstractTagBeanService implements TagBeanService {
    /**
     * 计算各个标签值(抽象方法,子类实现)
     *
     * @param tag 需要计算的标签集合
     * @return 标签计算结果
     */
    public abstract TagBeanResult doGetTagValue(String tag);

    /**
     * 检查参数是否合法
     *
     * @return 是否合法
     */
    public abstract Boolean isParamValid();

    /**
     * 标签计算模板方法
     *
     * @return 标签计算结果
     */
    @Override
    public TagBeanResult excute() {
        TagBeanResult tagBeanResult = null;
        String tag = getTag();
        if (isParamValid()) {
            tagBeanResult = doGetTagValue(tag);
        }
        saveToDb(tag, tagBeanResult);

        System.out.println(tagBeanResult);
        return tagBeanResult;
    }

    /**
     * 标签计算结果备份到数据库
     *
     * @param tag           标签参数
     * @param tagBeanResult 计算结果
     */
    private void saveToDb(String tag, TagBeanResult tagBeanResult) {
        System.out.println("Save to db.");
    }

    /**
     * 根据房前线程获取流程对应标签
     *
     * @return 标签名
     */
    public String getTag() {
        // 根据当前线程获取对应标签值
        return "";
    }
}
