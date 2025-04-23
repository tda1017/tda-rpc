package com.tda.provider;

import com.tda.common.service.UserService;
import com.tda.rpc.RpcApplication;
import com.tda.rpc.config.RegistryConfig;
import com.tda.rpc.config.RpcConfig;
import com.tda.rpc.model.ServiceMetaInfo;
import com.tda.rpc.registry.LocalRegistry;
import com.tda.rpc.registry.Registry;
import com.tda.rpc.registry.RegistryFactory;
import com.tda.rpc.server.HttpServer;
import com.tda.rpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
