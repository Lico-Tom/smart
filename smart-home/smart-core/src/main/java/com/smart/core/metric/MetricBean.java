package com.smart.core.metric;

import com.smart.core.metric.domain.MetricType;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Timer;
import io.prometheus.client.Histogram;

/**
 * @author Lico-Tom
 * 2024/6/15 8:47
 * @version V1.0
 */
public interface MetricBean {

    /**
     * 获取计数器
     *
     */
    Counter counter(String metricName);

    /**
     * 获取仪表盘
     *
     */
    Gauge gauge(String metricName);

    /**
     * 获取直方图
     *
     */
    Histogram histogram(String metricName);

    /**
     * 获取计时器
     *
     */
    Timer timer(String metricName);

    /**
     * 获取摘要
     *
     */
    DistributionSummary summary(String metricName);

    /**
     * 注册指标
     *
     */
    void registry(String metricName, MetricType metricType, String... tags);

}
