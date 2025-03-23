package com.tda.provider;

import com.tda.common.service.UserService;
//import com.tda.rpc.registry.LocalRegistry;
import com.tda.rpc.registry.LocalRegistry;
import com.tda.rpc.server.HttpServer;
import com.tda.rpc.server.VertxHttpServer;

public class Provider {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
