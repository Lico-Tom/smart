package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.UserRoleRelation;
import com.smart.security.service.UserRoleRelationService;
import com.smart.security.mapper.UserRoleRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_user_role_relation(后台用户和角色关系表)】的数据库操作Service实现
* @createDate 2023-12-12 00:24:04
*/
@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation>
    implements UserRoleRelationService{

}




