package com.smart.security.service;

import com.smart.security.domain.RoleMenuRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.security.model.RoleMenuRelationExample;

/**
* @author lizhonghao
* @description 针对表【t_role_menu_relation(后台角色菜单关系表)】的数据库操作Service
* @createDate 2023-12-04 22:17:22
*/
public interface RoleMenuRelationService extends IService<RoleMenuRelation> {

    void deleteByExample(RoleMenuRelationExample relationExample);
}
