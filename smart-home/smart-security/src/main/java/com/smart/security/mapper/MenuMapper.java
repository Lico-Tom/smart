package com.smart.security.mapper;

import com.smart.security.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_menu(后台菜单表)】的数据库操作Mapper
* @createDate 2023-12-04 22:17:21
* @Entity com.smart.security.domain.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectMenusByRoleId(Long roleId);
}




