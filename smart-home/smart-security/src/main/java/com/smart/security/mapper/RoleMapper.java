package com.smart.security.mapper;

import com.smart.security.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_role(后台用户角色表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:22
* @Entity com.smart.security.domain.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    boolean updateStatusById(Long id, Integer status);
}




