package com.smart.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.security.domain.UpdatePasswordParam;
import com.smart.security.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.security.domain.UserParam;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-12-03 16:13:55
*/
public interface UserService extends IService<User> {

    /**
     * 注册功能
     *
     * @param userParam
     * @return
     */
    User register(UserParam userParam);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token的功能
     *
     * @param token
     * @return
     */
    String refreshToken(String token);

    /**
     * 根据用户名获取后台管理员
     *
     * @param username
     * @return
     */
    User getAdminByUsername(String username);

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<User> list(String keyword, int pageSize, int pageNum);

    /**
     * 分页查询用户
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<User> list(int currentPage, int pageSize, User user);

    /**
     * 修改密码
     *
     * @param updatePasswordParam
     * @return
     */
    int updatePassword(UpdatePasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取缓存服务
     *
     * @return userCacheService
     */
    UserCacheService getCacheService();

}
