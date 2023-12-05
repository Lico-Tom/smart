package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.RolePermissionRelation;
import com.smart.security.service.RolePermissionRelationService;
import com.smart.security.mapper.RolePermissionRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_role_permission_relation(后台用户角色和权限关系表)】的数据库操作Service实现
* @createDate 2023-12-04 22:17:22
*/
@Service
public class RolePermissionRelationServiceImpl extends ServiceImpl<RolePermissionRelationMapper, RolePermissionRelation>
    implements RolePermissionRelationService{

}




