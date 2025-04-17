package com.tda.rpc.fault.retry;

import com.tda.rpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * @author: TDA
 * @date: 2025/4/16 17:48
 * @description:
 */
public interface RetryStrategy {
    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
