package com.tda.rpc.config;

import com.tda.rpc.fault.retry.RetryStrategyKeys;
import com.tda.rpc.fault.tolerant.TolerantStrategyKeys;
import com.tda.rpc.loadbalancer.LoadBalancerKeys;
import lombok.Data;

/**
 * RPC 框架配置
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "tda-rpc";

    /**
     * 版本号
     */
    private String version = "1.4";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    //todo 为什么需要public static 上面的不用
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;
}
