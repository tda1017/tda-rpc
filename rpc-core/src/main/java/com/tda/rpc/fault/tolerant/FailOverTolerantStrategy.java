package com.tda.rpc.fault.tolerant;

import com.tda.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author: TDA
 * @date: 21/4/2025 下午4:32
 * @description: 转移到其他服务节点
 */
public class FailOverTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 获取其他服务节点并调用
        return null;
    }
}
