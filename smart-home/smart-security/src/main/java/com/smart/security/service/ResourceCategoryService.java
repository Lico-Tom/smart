package com.smart.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.security.domain.ResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_resource_category(资源分类表)】的数据库操作Service
* @createDate 2023-12-04 22:17:21
*/
public interface ResourceCategoryService extends IService<ResourceCategory> {

    IPage<ResourceCategory> list(ResourceCategory resourceCategory, int pageSize, int currentPage);
}
