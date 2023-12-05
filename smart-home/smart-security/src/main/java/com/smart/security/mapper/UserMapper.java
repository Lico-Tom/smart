package com.smart.security.mapper;

import com.smart.security.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author lizhonghao
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-12-03 16:13:55
* @Entity com.smart.security.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据username查询用户信息
     *
     * @param username
     * @return
     */
    User selectByUsername(@Param("username") String username);
}




