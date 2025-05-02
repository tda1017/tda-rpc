package com.tda.rpc.loadbalancer;

import com.tda.rpc.model.ServiceMetaInfo;
import io.vertx.core.http.HttpServerRequest;

import java.util.List;
import java.util.Map;

/**
 * @author: TDA
 * @date: 2025/4/16 15:06
 * @description: 根据请求客户端的 IP 地址来计算 Hash 值，保证同 IP 的请求发送给相同的服务提供者
 */
//todo 测试一致性 Hash 负载均衡器
public class ConsistentHashLoadBalancer implements LoadBalancer {

    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
        return null;
    }

    /**
     * 根据 Hash 选择服务
     *
     * @param requestParams
     * @param serviceMetaInfoList
     * @param request
     * @return
     */
    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList,
                                  HttpServerRequest request) {
        // 拿到请求客户端的 IP 地址
        String clientIp = getClientIp(request);
        // 根据 IP 地址计算HASH
        // 将 hashCode() 结果的最高位（符号位）强制置为 0, 强制将哈希值转换为非负数
        int hash = clientIp.hashCode() & 0x7FFFFFFF;
        int index = hash % serviceMetaInfoList.size();

        return serviceMetaInfoList.get(index);
    }

    /**
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public static String getClientIp(HttpServerRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.remoteAddress().host();
        }
        // 处理多级代理（取第一个IP）
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}
