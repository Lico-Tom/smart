package com.smart.farm.forage.mapper;

import com.smart.farm.forage.domain.PigFeed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_pig_feed(每包猪饲料表)】的数据库操作Mapper
* @createDate 2023-12-14 00:25:41
* @Entity com.smart.farm.forage.domain.PigFeed
*/
@Mapper
public interface PigFeedMapper extends BaseMapper<PigFeed> {

}




