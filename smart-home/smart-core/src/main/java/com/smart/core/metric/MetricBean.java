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
     * @param metricName
     * @return
     */
    Counter counter(String metricName);

    /**
     * 获取仪表盘
     *
     * @param metricName
     * @return
     */
    Gauge gauge(String metricName);

    /**
     * 获取直方图
     *
     * @param metricName
     * @return
     */
    Histogram histogram(String metricName);

    /**
     * 获取计时器
     *
     * @param metricName
     * @return
     */
    Timer timer(String metricName);

    /**
     * 获取摘要
     *
     * @param metricName
     * @return
     */
    DistributionSummary summary(String metricName);

    /**
     * 注册指标
     *
     * @param metricName
     * @param metricType
     * @param tags
     */
    void registry(String metricName, MetricType metricType, String... tags);

}
