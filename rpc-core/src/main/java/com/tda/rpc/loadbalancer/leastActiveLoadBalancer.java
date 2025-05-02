package com.tda.rpc.loadbalancer;

import com.tda.rpc.model.ServiceMetaInfo;
import io.vertx.core.http.HttpServerRequest;

import java.util.List;
import java.util.Map;

/**
 * @author: TDA
 * @date: 29/4/2025 下午11:39
 * @description: 最少活跃数均衡负载器
 * todo 是否需要 AtomicInteger
 */
public class leastActiveLoadBalancer implements LoadBalancer {
//    static Map<ServiceMetaInfo, AtomicInteger> activeCounts = new ConcurrentHashMap<>();

    private static boolean setActiveCounts(int index, List<ServiceMetaInfo> serviceMetaInfoList, boolean isAdd) {
        // 使用 Map 记录每个节点的活跃数
        ServiceMetaInfo serviceMetaInfo = serviceMetaInfoList.get(index);
        if (isAdd) {
            serviceMetaInfo.setActiveCounts(serviceMetaInfo.getActiveCounts() + 1);
            return true;
        } else {
            // 判断服务活跃数是否为 0
            if (serviceMetaInfo.getActiveCounts() == 0) {
                System.out.println("activeCounts = 0!");
                return false;
            }
            serviceMetaInfo.setActiveCounts(serviceMetaInfo.getActiveCounts() - 1);
            return true;
        }
//        activeCounts.put("server1", new AtomicInteger(0));
//        activeCounts.put("server2", new AtomicInteger(0));
    }

    /**
     * 选择最少活跃点数的服务
     *
     * @return
     */
    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
//        String selectedServer = null;
        int minActive = Integer.MAX_VALUE;
        int index = 0;
        int selectedIndex = 0;

        for (ServiceMetaInfo serviceMetaInfo : serviceMetaInfoList) {
            // 查询每个服务当前的活跃数
            int activeCounts = serviceMetaInfo.getActiveCounts();
            // 当查找到的最小活跃数小于当前查找的活跃数，更换服务提供者
            if (activeCounts < minActive) {
                minActive = activeCounts;
                selectedIndex = index;
            }
            index++;
        }
        // 判断更改活跃数是否成功
        if (setActiveCounts(selectedIndex, serviceMetaInfoList, true)) {
            return serviceMetaInfoList.get(selectedIndex);
        } else {
            // 默认给第一个服务提供者
            return serviceMetaInfoList.get(0);
        }

    }

    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList,
                                  HttpServerRequest request) {
        return null;
    }
}
