package cn.forgeeks.threaddemo.tencentDemo;

import cn.forgeeks.threaddemo.tencentDemo.service.TagBeanService;
import cn.forgeeks.threaddemo.tencentDemo.util.SingletonBetBankTagBeanResource;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    /**
     * 计算风控标签值  (涉及: 设计模式模板方法单例 线程隔离threadlocal 线程池)
     *
     * @param args 模拟参数
     */
    public static void main(String[] args) {
        // 初始化线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 8,
                100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000_000));
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            poolExecutor.execute(() -> {
                // 模拟设置标签值
                ThreadLocal<String> tagValue = new ThreadLocal<>();
                tagValue.set("tag" + finalI);
                // 获取单例service 计算标签值
                TagBeanService tagBeanService = SingletonBetBankTagBeanResource.getIntance();
                System.out.println(tagBeanService.excute());
            });
        }
    }
}
