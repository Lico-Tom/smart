package com.smart.batch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.batch.domain.Bloginfo;
import com.smart.batch.service.BloginfoService;
import com.smart.batch.mapper.BloginfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author lizhonghao
 * @description 针对表【t_bloginfo】的数据库操作Service实现
 * @createDate 2023-11-15 19:27:54
 */
@Slf4j
@Service
public class BloginfoServiceImpl extends ServiceImpl<BloginfoMapper, Bloginfo>
        implements BloginfoService {

    @Override
    @Retryable(retryFor = Exception.class, maxAttempts = 4,
            backoff = @Backoff(delay = 2000L, multiplier = 3), recover = "saveRecover")
    public boolean saveFailRetry(Bloginfo bloginfo) {
        return save(bloginfo);
    }

    @Recover
    public boolean saveRecover(Exception e, boolean bool) {
        log.error("save fail. ", e);
        return bool;
    }

}




