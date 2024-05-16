package com.smart.task;

import com.smart.core.domain.Lock;
import com.smart.core.lock.LockService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Lico-Tom
 * 2023/11/2 23:03
 * @version V1.0
 *  多实例场景下避免重复执行任务，使用了mysql数据库锁
 */
@Aspect
@Component
public class TaskDistributedLock {

    private final LockService lockService;

    @Autowired
    public TaskDistributedLock(LockService lockService) {
        this.lockService = lockService;
    }

    @Pointcut(value = "execution(public void com.smart.task.ins.*.execute(Object))")
    public void taskLockPoint() {
    }

    @Around(value = "taskLockPoint()", argNames = "proceedingJoinPoint")
    public void taskLockInspection(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String classPath = proceedingJoinPoint.getTarget().getClass().getName();
        Lock lock = new Lock(classPath, 30, new Date());
        try {
            if (!lockService.isTryLock(lock)) {
                return;
            }
            proceedingJoinPoint.proceed();
        } catch (Exception ignored) {
        } finally {
            lockService.stopLock(lock);
        }

    }
}
