package com.smart.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.Role;
import com.smart.security.domain.User;
import com.smart.security.service.RoleService;
import com.smart.security.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhonghao
 * @description 针对表【t_role(后台用户角色表)】的数据库操作Service实现
 * @createDate 2023-12-04 22:17:22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Object getMenuList(Long id) {
        return null;
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", keyword);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(pageSize);
        return roleMapper.selectList(rolePage, queryWrapper);
    }

    @Override
    public boolean updateStatusById(Long id, Integer status) {
        roleMapper.updateStatusById(id, status);
        return false;
    }
}




