package com.tda.provider;

import com.tda.common.service.UserService;
import com.tda.rpc.RpcApplication;
import com.tda.rpc.registry.LocalRegistry;
import com.tda.rpc.server.VertxHttpServer;
import com.tda.rpc.server.HttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
