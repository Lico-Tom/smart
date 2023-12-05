package com.smart.security.service;

import com.smart.security.domain.RoleResourceRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.security.model.RoleResourceRelationExample;

/**
* @author lizhonghao
* @description 针对表【t_role_resource_relation(后台角色资源关系表)】的数据库操作Service
* @createDate 2023-12-04 22:17:22
*/
public interface RoleResourceRelationService extends IService<RoleResourceRelation> {

    boolean deleteByExample(RoleResourceRelationExample relationExample);
}
