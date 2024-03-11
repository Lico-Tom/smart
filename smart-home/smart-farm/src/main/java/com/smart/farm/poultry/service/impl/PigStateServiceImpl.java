package com.smart.farm.poultry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.farm.poultry.domain.PigState;
import com.smart.farm.poultry.service.PigStateService;
import com.smart.farm.poultry.mapper.PigStateMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_pig_state(猪属性表)】的数据库操作Service实现
* @createDate 2023-12-14 00:23:51
*/
@Service
public class PigStateServiceImpl extends ServiceImpl<PigStateMapper, PigState> implements PigStateService{


    private final PigStateMapper pigStateMapper;

    @Autowired
    public PigStateServiceImpl(PigStateMapper pigStateMapper) {
        this.pigStateMapper = pigStateMapper;
    }

    @Override
    public IPage<PigState> list(PigState pigState, int pageSize, int currentPage) {
        QueryWrapper<PigState> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(pigState.getId() != null, "id", pigState.getId())
                .eq(Strings.isNotEmpty(pigState.getPurchaser()), "purchaser", pigState.getPurchaser())
                .eq(pigState.getPigstyNumber() != null, "pigsty_number", pigState.getPigstyNumber());
        IPage<PigState> page = new Page<>(currentPage, pageSize, count(queryWrapper));
        queryWrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return pigStateMapper.selectPage(page, queryWrapper);
    }
}




