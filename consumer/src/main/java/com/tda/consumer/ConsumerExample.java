package com.tda.consumer;

import com.tda.rpc.config.RpcConfig;
import com.tda.rpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}