package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.Permission;
import com.smart.security.service.PermissionService;
import com.smart.security.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_permission(后台用户权限表)】的数据库操作Service实现
* @createDate 2023-12-04 22:17:21
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




