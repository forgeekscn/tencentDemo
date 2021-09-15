package cn.forgeeks.threaddemo.tencentDemo.util;

import cn.forgeeks.threaddemo.tencentDemo.impl.NetBankTagBeanServiceImpl;

public class SingletonBetBankTagBeanResource {
    private SingletonBetBankTagBeanResource() {}

    private static class Singleton2Houdler{
        private static NetBankTagBeanServiceImpl INSTANCE = new NetBankTagBeanServiceImpl();
    }

    /**
     * 你用静态累不累获取线程安全的单例
     * @return
     */
    public static NetBankTagBeanServiceImpl getIntance(){
        return SingletonBetBankTagBeanResource.Singleton2Houdler.INSTANCE;
    }
}
