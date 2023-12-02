package com.smart.admin.service;

import com.smart.admin.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_admin(后台用户表)】的数据库操作Service
* @createDate 2023-11-23 22:19:16
*/
public interface AdminService extends IService<Admin> {

    void register(String username, String password, String telephone, String authCode);

    String login(String username, String password);

    Admin getCurrentMember();
}
