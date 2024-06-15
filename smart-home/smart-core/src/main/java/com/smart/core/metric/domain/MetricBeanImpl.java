package com.smart.core.metric.domain;

import com.smart.core.metric.MetricBean;
import com.smart.core.utils.StrUtil;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.prometheus.client.Histogram;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lico-Tom
 * 2024/6/14 23:24
 * @version V1.0
 */
@Slf4j
@Component
public class MetricBeanImpl implements MetricBean {

    private final Map<String, Counter> counterMap = new ConcurrentHashMap<>();

    private final Map<String, Gauge> gaugeMap = new ConcurrentHashMap<>();

    private final Map<String, Histogram> histogramMap = new ConcurrentHashMap<>();

    private final Map<String, DistributionSummary> distributionSummaryMap = new ConcurrentHashMap<>();

    private final Map<String, Timer> timerMap = new ConcurrentHashMap<>();

    private final MeterRegistry meterRegistry;


    public MetricBeanImpl(@Autowired MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    private void addMetric(String metricName, String[] tags, MetricType metricType) {
        String tagsStr = StrUtil.arrToStr(tags);
        switch (metricType) {
            case COUNTER:
                counterMap.put(metricName + "_" + tagsStr, Counter
                        .builder(metricName)
                        .tags(tags)
                        .register(meterRegistry));
                break;
            case GAUGE:
                gaugeMap.put(metricName + "_" + tagsStr, Gauge
                        .builder(metricName, () -> new Random().nextDouble())
                        .tags(tags)
                        .register(meterRegistry));
                break;
            case HISTOGRAM:
                histogramMap.put(metricName + "_" + tagsStr, Histogram
                        .build()
                        .name(metricName)
                        .labelNames(tags)
                        .register());
                break;
            case SUMMARY:
                distributionSummaryMap.put(metricName + "_" + tagsStr, DistributionSummary
                        .builder(metricName)
                        .tags(tags)
                        .register(meterRegistry));
                break;
            case TIMER:
                timerMap.put(metricName + "_" + tagsStr, Timer.builder(metricName)
                        .publishPercentiles(0.5, 0.75, 0.9, 0.95, 0.99, 0.999)
                        .publishPercentileHistogram(true)
                        .tags(tags)
                        .register(meterRegistry));
                break;
            case UNTYPED:
                log.warn("Untyped metric not supported");
                break;
            default:
                log.error("Metric type not supported: {}", metricType);
                break;
        }
    }

    @PostConstruct
    private void init() throws IllegalAccessException {
        MetricConstant obj = new MetricConstant();
        Class<? extends MetricConstant> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        HashMap<String, Object> metricMap = new HashMap<>(declaredFields.length);
        for (Field field : declaredFields) {
            metricMap.put(field.getName(), field.get(obj));
        }
        for (Field field : declaredFields) {
            if (!field.getName().contains("TAGS")) {
                String metricName = (String) metricMap.get(field.getName());
                String[] tags = (String[]) metricMap.get(field.getName() + "_TAGS");
                if (tags == null || tags.length == 0) {
                    continue;
                }
                String metricType = field.getName().split("_")[0];
                addMetric(metricName, tags, MetricType.valueOf(metricType));
            }
        }
    }


    @Override
    public Counter counter(String metricName) {
        return counterMap.getOrDefault(metricName, null);
    }

    @Override
    public Gauge gauge(String metricName) {
        return gaugeMap.getOrDefault(metricName, null);
    }

    @Override
    public Histogram histogram(String metricName) {
        return histogramMap.getOrDefault(metricName, null);
    }

    @Override
    public Timer timer(String metricName) {
        return timerMap.getOrDefault(metricName, null);
    }

    @Override
    public DistributionSummary summary(String metricName) {
        return distributionSummaryMap.getOrDefault(metricName, null);
    }

    @Override
    public void registry(String metricName, MetricType metricType, String... tags) {
        addMetric(metricName, tags, metricType);
    }

}
