package com.smart.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}




