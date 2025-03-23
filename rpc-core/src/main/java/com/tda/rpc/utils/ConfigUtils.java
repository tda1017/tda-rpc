package com.tda.rpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 配置工具类
 */
public class ConfigUtils {
    
    public static <T> T loadConfig(Class<T> tClass, String prefix){
        return loadConfig(tClass, prefix, "");
    }
    
    /**
     * @Description:
     * @param tClass
     * @param prefix
     * @param environment
     * @param <T>
     * @return: 
     * @Author:  TDA
     * @date:  22/3/2025 下午3:17
     */
    public static <T> T loadConfig(Class<T> tClass, String  prefix, String  environment){
        StringBuilder configFileBuilder = new StringBuilder("application");
        if(StrUtil.isNotBlank(environment)){
            configFileBuilder.append("-").append(environment);
        }
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());
        return props.toBean(tClass, prefix);
    }
}
