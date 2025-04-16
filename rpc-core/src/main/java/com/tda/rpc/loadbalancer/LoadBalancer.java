package com.tda.rpc.loadbalancer;

import com.tda.rpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

/**
 * @author: TDA
 * @date: 2025/4/16 2:45
 * @description:
 */
public interface LoadBalancer {

    /**
     * @param requestParams
     * @param serviceMetaInfoList
     * @return
     */
    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);
}
