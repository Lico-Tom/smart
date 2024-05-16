package com.smart.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.domain.Resource;
import com.smart.security.domain.ResourceCategory;
import com.smart.security.service.ResourceCategoryService;
import com.smart.security.mapper.ResourceCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_resource_category(资源分类表)】的数据库操作Service实现
* @createDate 2023-12-04 22:17:21
*/
@Service
public class ResourceCategoryServiceImpl extends ServiceImpl<ResourceCategoryMapper, ResourceCategory>
    implements ResourceCategoryService{

    private final ResourceCategoryMapper resourceCategoryMapper;

    public ResourceCategoryServiceImpl(ResourceCategoryMapper resourceCategoryMapper) {
        this.resourceCategoryMapper = resourceCategoryMapper;
    }

    @Override
    public IPage<ResourceCategory> list(ResourceCategory resourceCategory, int pageSize, int currentPage) {
        QueryWrapper<ResourceCategory> wrapper = new QueryWrapper<>();
        wrapper.eq(resourceCategory.getId() != null, "id", resourceCategory.getId());
        wrapper.eq(resourceCategory.getName() != null, "name", resourceCategory.getName());
        wrapper.eq(resourceCategory.getCreateTime() != null, "create_time", resourceCategory.getCreateTime());
        Page<ResourceCategory> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return resourceCategoryMapper.selectPage(page, wrapper);
    }
}




