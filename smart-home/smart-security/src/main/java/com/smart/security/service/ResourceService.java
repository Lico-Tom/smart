package com.smart.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    IPage<Resource> list(Resource resource, Integer pageSize, Integer pageNum);

    List<Resource> getResourceList(Long userId);

    List<Resource> listAll();
}
