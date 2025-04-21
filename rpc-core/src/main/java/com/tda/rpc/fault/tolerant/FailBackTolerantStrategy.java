package com.tda.rpc.fault.tolerant;

import com.tda.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author: TDA
 * @date: 21/4/2025 下午4:31
 * @description: 降级到其他服务
 */
public class FailBackTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 获取降级的服务并调用
        return null;
    }
}
