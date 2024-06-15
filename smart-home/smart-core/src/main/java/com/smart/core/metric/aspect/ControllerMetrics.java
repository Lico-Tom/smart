package com.smart.core.metric.aspect;

import com.smart.core.metric.MetricBean;
import com.smart.core.metric.domain.MetricConstant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author Lico-Tom
 * 2024/6/17 23:52
 * @version V1.0
 */
@Slf4j
@Aspect
@Component
public class ControllerMetrics {

    private final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());


    private final MetricBean metricBean;

    public ControllerMetrics(@Autowired MetricBean metricBean) {
        this.metricBean = metricBean;
    }

    @Pointcut(value = "execution(public * com.smart.*.controller..*(..))")
    public void apiMetricPoint() {
    }


    @Around(value="apiMetricPoint()", argNames = "proceedingJoinPoint")
    public Object metricMonitor(ProceedingJoinPoint proceedingJoinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        try {

            String requestURI = request.getRequestURI();
            String remoteUser = request.getRemoteUser();
            long startTime = System.currentTimeMillis();
            Object proceed = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long costTime = endTime - startTime;
            if (remoteUser == null) {
                remoteUser = "anonymous";
            }
            String[] tags = {"request_uri",requestURI, "remote_user", remoteUser};
            threadPool.execute(new MonitorRunnable(tags, costTime, metricBean));
            return proceed;
        } catch (Throwable e) {
            return e;
        }
    }
}
