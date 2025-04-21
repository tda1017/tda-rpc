package com.tda.rpc.fault.tolerant;

import com.tda.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author: TDA
 * @date: 21/4/2025 下午4:28
 * @description: 快速失败（立刻通知外层调用方）
 */
public class FailFastTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        throw new RuntimeException("服务报错", e);
    }
}
