package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.RoleMenuRelation;
import com.smart.security.model.RoleMenuRelationExample;
import com.smart.security.service.RoleMenuRelationService;
import com.smart.security.mapper.RoleMenuRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_role_menu_relation(后台角色菜单关系表)】的数据库操作Service实现
* @createDate 2023-12-04 22:17:22
*/
@Service
public class RoleMenuRelationServiceImpl extends ServiceImpl<RoleMenuRelationMapper, RoleMenuRelation>
    implements RoleMenuRelationService{

    @Override
    public void deleteByExample(RoleMenuRelationExample relationExample) {

    }
}




