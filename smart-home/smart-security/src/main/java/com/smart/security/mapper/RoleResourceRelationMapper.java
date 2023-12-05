package com.smart.security.mapper;

import com.smart.security.domain.RoleResourceRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_role_resource_relation(后台角色资源关系表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:22
* @Entity com.smart.security.domain.RoleResourceRelation
*/
@Mapper
public interface RoleResourceRelationMapper extends BaseMapper<RoleResourceRelation> {

}




