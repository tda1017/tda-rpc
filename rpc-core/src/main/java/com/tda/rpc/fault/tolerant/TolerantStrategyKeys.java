package com.tda.rpc.fault.tolerant;

/**
 * @author: TDA
 * @date: 21/4/2025 下午4:35
 * @description: 容错策略键名常量
 */
public class TolerantStrategyKeys {

    /**
     * 故障恢复
     */
    public static String FAIL_BACK = "failBack";

    /**
     * 快速失败
     */
    public static String FAIL_FAST = "failFast";

    /**
     * 故障转移
     */
    public static String FAIL_OVER = "failOver";

    /**
     * 静默处理
     */
    public static String FAIL_SAFE = "failSafe";
}
