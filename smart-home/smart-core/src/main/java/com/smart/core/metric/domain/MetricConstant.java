package com.smart.core.metric.domain;

/**
 * @author Lico-Tom
 * 2024/6/14 23:26
 * @version V1.0
 * @Descroption 性能存储指标常量
 * 匹配规则 :
 * 指标参数名称前缀为 METRICTYPE_
 * 指标参数名称标签命名为 指标参数名称_TAGS
 */
public class MetricConstant {

    public static final String COUNTER_SERVER_API = "smart_server_request_counter";

    public static final String SUMMARY_SERVER_API = "smart_server_request_cost";


    public static final String COUNTER_SUCCESS_COUNTER = "perf_storage_success";

    protected static final String[] COUNTER_SUCCESS_COUNTER_TAGS = {"perf_storage_success", "success"};

}
