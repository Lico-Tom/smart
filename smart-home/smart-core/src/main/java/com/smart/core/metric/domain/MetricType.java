package com.smart.core.metric.domain;


/**
 * @author Lico-Tom
 * 2024/6/15 0:24
 * @version V1.0
 */
public enum MetricType {
    /**
     * COUNTER 计数器
     */
    COUNTER,
    /**
     * GAUGE 度量
     */
    GAUGE,
    /**
     * HISTOGRAM 直方图
     */
    HISTOGRAM,
    /**
     * SUMMARY 摘要
     */
    SUMMARY,
    /**
     * TIMER 计时器
     */
    TIMER,
    /**
     * UNTYPED 未指定类型
     */
    UNTYPED
}
