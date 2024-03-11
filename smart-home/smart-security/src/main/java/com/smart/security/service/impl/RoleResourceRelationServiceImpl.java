package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.RoleResourceRelation;
import com.smart.security.model.RoleResourceRelationExample;
import com.smart.security.service.RoleResourceRelationService;
import com.smart.security.mapper.RoleResourceRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_role_resource_relation(后台角色资源关系表)】的数据库操作Service实现
* @createDate 2023-12-04 22:17:22
*/
@Service
public class RoleResourceRelationServiceImpl extends ServiceImpl<RoleResourceRelationMapper, RoleResourceRelation>
    implements RoleResourceRelationService{

    @Override
    public boolean deleteByExample(RoleResourceRelationExample relationExample) {
        return false;
    }
}




