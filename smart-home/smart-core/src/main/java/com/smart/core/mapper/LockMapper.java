package com.smart.core.mapper;

import com.smart.core.domain.Lock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_lock】的数据库操作Mapper
* @createDate 2023-11-02 22:52:46
* @Entity com.smart.core.domain.Lock
*/
@Mapper
public interface LockMapper extends BaseMapper<Lock> {

}




