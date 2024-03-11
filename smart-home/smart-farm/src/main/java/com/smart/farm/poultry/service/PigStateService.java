package com.smart.farm.poultry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.farm.poultry.domain.PigState;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_pig_state(猪属性表)】的数据库操作Service
* @createDate 2023-12-14 00:23:51
*/
public interface PigStateService extends IService<PigState> {

    /**
     * 条件查询
     * @param pigState
     * @param pageSize
     * @param currentPage
     * @return
     */
    IPage<PigState> list(PigState pigState, int pageSize, int currentPage);
}
