package com.smart.farm.poultry.mapper;

import com.smart.farm.poultry.domain.PigState;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_pig_state(猪属性表)】的数据库操作Mapper
* @createDate 2023-12-14 00:23:51
* @Entity com.smart.farm.poultry.domain.PigState
*/
@Mapper
public interface PigStateMapper extends BaseMapper<PigState> {

}




