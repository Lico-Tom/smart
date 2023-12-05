package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.Resource;
import com.smart.security.domain.RoleResourceRelation;
import com.smart.security.model.RoleResourceRelationExample;
import com.smart.security.service.ResourceService;
import com.smart.security.mapper.ResourceMapper;
import com.smart.security.service.RoleResourceRelationService;
import com.smart.security.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhonghao
 * @description 针对表【t_resource(后台资源表)】的数据库操作Service实现
 * @createDate 2023-12-04 22:17:21
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    private final ResourceMapper resourceMapper;

    private final UserCacheService userCacheService;

    private final RoleResourceRelationService roleResourceRelationService;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper,
                               RoleResourceRelationService roleResourceRelationService,
                               UserCacheService userCacheService) {
        this.resourceMapper = resourceMapper;
        this.roleResourceRelationService = roleResourceRelationService;
        this.userCacheService = userCacheService;
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        return resourceMapper.listResourceByRoleId(roleId);
    }

    @Override
    public boolean allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        RoleResourceRelationExample relationExample = new RoleResourceRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationService.deleteByExample(relationExample);
        List<RoleResourceRelation> roleResourceRelations = resourceIds.stream().map(resourceId -> {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            return relation;
        }).collect(Collectors.toList());
        boolean isSaveBatch = roleResourceRelationService.saveBatch(roleResourceRelations);
        userCacheService.delResourceListByRole(roleId);
        return isSaveBatch;
    }

    @Override
    public List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        List<Resource> resourceList = resourceMapper.getResourceList(userId);
        return resourceList;
    }
}




