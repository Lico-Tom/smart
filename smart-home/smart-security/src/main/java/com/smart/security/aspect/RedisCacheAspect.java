package com.smart.security.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * Redis缓存切面，防止Redis宕机影响正常业务逻辑
 *
 * @author Lico-Tom
 * 2023/12/3 10:10
 * @version V1.0
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);


}
