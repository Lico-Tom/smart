package com.smart.security.service;

import com.smart.security.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.security.dto.MenuNode;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_menu(后台菜单表)】的数据库操作Service
* @createDate 2023-12-04 22:17:21
*/
public interface MenuService extends IService<Menu> {

    List<Menu> listMenu(Long roleId);

    boolean allocMenu(Long roleId, List<Long> menuIds);

    List<Menu> list(Long parentId, Integer pageSize, Integer pageNum);

    List<MenuNode> treeList();

    boolean updateHidden(Long id, Integer hidden);
}
