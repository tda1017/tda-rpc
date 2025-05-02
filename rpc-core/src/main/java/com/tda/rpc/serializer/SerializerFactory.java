package com.tda.rpc.serializer;

import com.tda.rpc.spi.SpiLoader;

/**
 * 序列化器工厂（用于获取序列化器对象）
 * 使用懒加载（懒汉式单例）的方式创建序列化器实例 4.24
 */
public class SerializerFactory {

    /**
     * 默认序列化器
     * volatile防止指令重排序，确保可见性
     */
    private static volatile Serializer DEFAULT_SERIALIZER;

    public static Serializer getInstance(String key) {
        // 默认使用JDK序列化
        // 第一次检查（避免不必要的同步）
        if (DEFAULT_SERIALIZER == null) {
            // 类锁会阻塞所有访问该类的线程，高并发场景谨慎使用
            synchronized (SerializerFactory.class) {
                // 第二次检查（确保线程安全）
                if (DEFAULT_SERIALIZER == null) {
                    // 默认使用JDK序列化器
                    DEFAULT_SERIALIZER = new JdkSerializer();
                    SpiLoader.load(Serializer.class);
                    return SpiLoader.getInstance(Serializer.class, key);
                }
            }
        }
//        return DEFAULT_SERIALIZER;

        // 指定了序列化器，使用SPI机制加载
        SpiLoader.load(Serializer.class);
        return SpiLoader.getInstance(Serializer.class, key);
    }

    /**
     * 根据key获取序列化器（SPI方式）
     *
     * @param key
     * @return
     */
//    public static Serializer getInstance(String key) {
//        return SpiLoader.getInstance(Serializer.class, key);
//    }

}
