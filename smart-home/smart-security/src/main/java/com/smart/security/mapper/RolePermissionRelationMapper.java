package com.smart.security.mapper;

import com.smart.security.domain.RolePermissionRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_role_permission_relation(后台用户角色和权限关系表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:22
* @Entity com.smart.security.domain.RolePermissionRelation
*/
@Mapper
public interface RolePermissionRelationMapper extends BaseMapper<RolePermissionRelation> {

}




