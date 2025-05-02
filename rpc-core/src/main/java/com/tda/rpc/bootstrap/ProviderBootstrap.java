package com.tda.rpc.bootstrap;

import com.tda.rpc.RpcApplication;
import com.tda.rpc.config.RegistryConfig;
import com.tda.rpc.config.RpcConfig;
import com.tda.rpc.model.ServiceMetaInfo;
import com.tda.rpc.model.ServiceRegisterInfo;
import com.tda.rpc.registry.LocalRegistry;
import com.tda.rpc.registry.Registry;
import com.tda.rpc.registry.RegistryFactory;
import com.tda.rpc.server.HttpServer;
import com.tda.rpc.server.VertxHttpServer;

import java.util.List;

/**
 * @author: TDA
 * @date: 23/4/2025 下午5:02
 * @description: 服务提供者启动类（初始化）
 */
public class ProviderBootstrap {

    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        // RPC 框架初始化
        RpcApplication.init();
        // 读取配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        for (ServiceRegisterInfo<?> serviceRegisterInfo : serviceRegisterInfoList) {
            String serviceName = serviceRegisterInfo.getServiceName();
            // 本地注册
            LocalRegistry.register(serviceName, serviceRegisterInfo.getImplClass());

            // 注册服务到注册中心
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
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
