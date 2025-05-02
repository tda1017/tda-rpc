package com.tda.rpc.bootstrap;

import com.tda.rpc.RpcApplication;

/**
 * @author: TDA
 * @date: 23/4/2025 下午5:50
 * @description: 服务消费者启动类（初始化）
 */
public class ConsumerBootstrap {

    /**
     * 初始化
     */
    public static void init() {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
    }
}
