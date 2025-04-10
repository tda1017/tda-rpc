package com.tda.rpc.registry;

import com.tda.rpc.spi.SpiLoader;

/**
 * @author: TDA
 * @date: 2025/4/3 16:09
 * @description: 注册中心工厂（用于获取注册中心对象）
 */
public class RegistryFactory {
    static {
        SpiLoader.load(Registry.class);
    }

    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Registry getInstance(String key) {
        return SpiLoader.getInstance(Registry.class, key);
    }

}
