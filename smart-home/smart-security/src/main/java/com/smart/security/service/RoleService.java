package com.smart.security.service;

import com.smart.security.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_role(后台用户角色表)】的数据库操作Service
* @createDate 2023-12-04 22:17:22
*/
public interface RoleService extends IService<Role> {

    Object getMenuList(Long id);

    List<Role> list(String keyword, Integer pageSize, Integer pageNum);

    boolean updateStatusById(Long id, Integer status);
}
