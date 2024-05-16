package com.smart.security.service.impl;

import com.smart.security.domain.Resource;
import com.smart.security.domain.User;
import com.smart.security.service.UserCacheService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户缓存操作Service实现类
 *
 * @author macro
 * @date 2020/3/13
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Override
    public void delUser(Long userId) {

    }

    @Override
    public void delResourceList(Long adminId) {

    }

    @Override
    public void delResourceListByRole(Long roleId) {

    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {

    }

    @Override
    public void delResourceListByResource(Long resourceId) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<Resource> resourceList) {

    }
}
