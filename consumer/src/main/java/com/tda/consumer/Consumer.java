package com.tda.consumer;

import com.tda.common.model.User;
import com.tda.common.service.UserService;
import com.tda.rpc.proxy.ServiceProxyFactory;

public class Consumer {
    public static void main(String[] args) {
        User user = new User();

        // 静态代理
//        UserService userService = new UserServiceProxy();

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        user.setName("tda");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
