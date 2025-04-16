package com.tda.rpc.loadbalancer;

/**
 * @author: TDA
 * @date: 2025/4/16 15:13
 * @description:
 */
public interface LoadBalancerKeys {

    /**
     * 轮询算法名
     */
    String ROUND_ROBIN = "roundRobin";

    String RANDOM = "random";

    String CONSISTENT_HASH = "consistentHash";
}
