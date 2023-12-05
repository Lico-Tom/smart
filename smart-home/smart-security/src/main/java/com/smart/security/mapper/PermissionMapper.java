package com.smart.security.mapper;

import com.smart.security.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_permission(后台用户权限表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:21
* @Entity com.smart.security.domain.Permission
*/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}




