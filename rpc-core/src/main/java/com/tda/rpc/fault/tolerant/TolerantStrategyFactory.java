package com.tda.rpc.fault.tolerant;

import com.tda.rpc.spi.SpiLoader;

/**
 * @author: TDA
 * @date: 21/4/2025 下午4:36
 * @description:
 */
public class TolerantStrategyFactory {

    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    private static final TolerantStrategy DEFAULT_RETRY_STRATEGY = new FailBackTolerantStrategy();

    public static TolerantStrategy getInstance(String key){
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }
}
