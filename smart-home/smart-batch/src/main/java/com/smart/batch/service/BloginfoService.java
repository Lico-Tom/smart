package com.smart.batch.service;

import com.smart.batch.domain.Bloginfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_bloginfo】的数据库操作Service
* @createDate 2023-11-15 19:27:54
*/
public interface BloginfoService extends IService<Bloginfo> {

    /**
     * 插入失败后重试三次
     *
     * @param bloginfo
     * @return
     */
    boolean saveFailRetry(Bloginfo bloginfo);

}
