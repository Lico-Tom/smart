package com.smart.batch.mapper;

import com.smart.batch.domain.Bloginfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_bloginfo】的数据库操作Mapper
* @createDate 2023-11-15 19:27:54
* @Entity com.smart.batch.domain.Bloginfo
*/
@Mapper
public interface BloginfoMapper extends BaseMapper<Bloginfo> {

}




