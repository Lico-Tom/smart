package com.smart.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.domain.Admin;
import com.smart.admin.domain.UserDetailsImpl;
import com.smart.admin.service.AdminService;
import com.smart.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_admin(后台用户表)】的数据库操作Service实现
* @createDate 2023-11-23 22:19:16
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{

    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    @Override
    public void register(String username, String password, String telephone, String authCode) {

    }

    @Override
    public String login(String username, String password) {
        adminMapper.selectByUsername()
        return null;
    }

    @Override
    public Admin getCurrentMember() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        UserDetailsImpl adminDetails = (UserDetailsImpl) auth.getPrincipal();
        return adminDetails.getAdmin();
    }
}




