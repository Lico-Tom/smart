package com.smart.admin.mapper;

import com.smart.admin.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_admin(后台用户表)】的数据库操作Mapper
* @createDate 2023-11-23 22:19:16
* @Entity com.smart.admin.domain.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    void selectByUsername(String username);
}




