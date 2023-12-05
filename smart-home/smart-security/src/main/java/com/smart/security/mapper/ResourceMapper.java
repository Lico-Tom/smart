package com.smart.security.mapper;

import com.smart.security.domain.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_resource(后台资源表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:21
* @Entity com.smart.security.domain.Resource
*/
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> listResourceByRoleId(Long roleId);

    List<Resource> getResourceList(Long userId);
}




