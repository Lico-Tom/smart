package com.smart.core.metric.aspect;

import com.smart.core.metric.MetricBean;
import com.smart.core.metric.domain.MetricConstant;
import com.smart.core.metric.domain.MetricType;
import com.smart.core.utils.StrUtil;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;

/**
 * @author Lico-Tom
 * 2024/6/18 0:13
 * @version V1.0
 */
public class MonitorRunnable implements Runnable {

    private final String[] tags;

    private final long costTime;

    private final MetricBean metricBean;


    public MonitorRunnable(String[] tags, long costTime, MetricBean metricBean) {
        this.tags = tags;
        this.costTime = costTime;
        this.metricBean = metricBean;
    }

    @Override
    public void run() {
        String tagsStr = "_" + StrUtil.arrToStr(tags);
        Counter counter = metricBean.counter(MetricConstant.COUNTER_SERVER_API + tagsStr);
        DistributionSummary distributionSummary = metricBean.summary(MetricConstant.SUMMARY_SERVER_API + tagsStr);
        if (counter == null) {
            metricBean.registry(MetricConstant.COUNTER_SERVER_API, MetricType.COUNTER, tags);
            counter = metricBean.counter(MetricConstant.COUNTER_SERVER_API + tagsStr);
        }
        if (distributionSummary == null) {
            metricBean.registry(MetricConstant.SUMMARY_SERVER_API, MetricType.SUMMARY, tags);
            distributionSummary = metricBean.summary(MetricConstant.SUMMARY_SERVER_API + tagsStr);
        }
        counter.increment();
        distributionSummary.record(costTime);

    }

}
