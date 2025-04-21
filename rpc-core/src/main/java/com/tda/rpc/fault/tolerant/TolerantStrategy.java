package com.tda.rpc.fault.tolerant;

import com.tda.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author: TDA
 * @date: 18/4/2025 上午12:43
 * @description:
 */
public interface TolerantStrategy {

    /**
     * 容错
     *
     * @param context 上下文，用于传递数据
     * @param e       异常
     * @return
     */
    RpcResponse doTolerant(Map<String, Object> context, Exception e);
}
