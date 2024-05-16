package com.smart.security.service;

import com.smart.security.domain.Resource;
import com.smart.security.domain.User;

import java.util.List;

/**
 * 后台用户缓存操作Service
 *
 * @author lizhonghao
 * @date 2020/12/3
 */
public interface UserCacheService {
    /**
     * 删除后台用户缓存
     *
     * @param userId
     */
    void delUser(Long userId);

    /**
     * 删除后台用户资源列表缓存
     *
     * @param adminId
     */
    void delResourceList(Long adminId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     *
     * @param roleId
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     *
     * @param roleIds
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     *
     * @param resourceId
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户信息
     *
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * 设置缓存后台用户信息
     *
     * @param user
     */
    void setUser(User user);

    /**
     * 获取缓存后台用户资源列表
     * @param userId
     * @return
     */
    List<Resource> getResourceList(Long userId);

    /**
     * 设置缓存后台用户资源列表
     * @Param adminId
     * @Param ResourceList
     */
    void setResourceList(Long adminId, List<Resource> resourceList);
}
