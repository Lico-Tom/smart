package com.smart.security.service;

import com.smart.security.domain.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_resource(后台资源表)】的数据库操作Service
* @createDate 2023-12-04 22:17:21
*/
public interface ResourceService extends IService<Resource> {

    List<Resource> listResource(Long roleId);

    boolean allocResource(Long roleId, List<Long> resourceIds);

    List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    List<Resource> getResourceList(Long userId);
}
