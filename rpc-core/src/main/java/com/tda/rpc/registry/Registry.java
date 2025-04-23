package com.tda.rpc.registry;

import com.tda.rpc.config.RegistryConfig;
import com.tda.rpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * @author: TDA
 * @date: 2025/4/3 15:11
 * @description:
 */
public interface Registry {

    /**
     * 初始化
     *
     * @param registryConfig
     */
    void init(RegistryConfig registryConfig);

    /**
     * 注册服务（服务端）
     *
     * @param serviceMetaInfo
     */
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;

    /**
     * 注销服务（服务端）
     *
     * @param serviceMetaInfo
     */
    void unRegister(ServiceMetaInfo serviceMetaInfo);

    /**
     * 心跳检测（服务端）
     */
    void heartBeat();

    /**
     * 服务发现（获取某服务的所有节点，消费端）
     *
     * @param serviceKey 服务键名
     */
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);

    /**
     * 服务销毁
     */
    void destroy();

    /**
     * 监听（消费端）
     *
     * @param serviceNodeKey
     */
    void watch(String serviceNodeKey);


}
