package com.smart.security.mapper;

import com.smart.security.domain.RoleMenuRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.security.model.RoleMenuRelationExample;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_role_menu_relation(后台角色菜单关系表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:22
* @Entity com.smart.security.domain.RoleMenuRelation
*/
@Mapper
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation> {

    int deleteByExample(RoleMenuRelationExample relationExample);
}




