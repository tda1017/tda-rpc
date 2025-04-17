package com.tda.rpc.fault.retry;

import com.tda.rpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author: TDA
 * @date: 2025/4/16 17:53
 * @description:
 */
@Slf4j
public class NoRetryStrategy implements RetryStrategy {

    /**
     * @param callable
     * @return
     * @throws Exception
     */
    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }
}
