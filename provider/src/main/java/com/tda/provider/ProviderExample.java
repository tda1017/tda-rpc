package com.tda.provider;

import com.tda.common.service.UserService;
import com.tda.rpc.bootstrap.ProviderBootstrap;
import com.tda.rpc.model.ServiceRegisterInfo;

import java.util.ArrayList;
import java.util.List;

public class ProviderExample {
    public static void main(String[] args) {
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(),
                UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}
