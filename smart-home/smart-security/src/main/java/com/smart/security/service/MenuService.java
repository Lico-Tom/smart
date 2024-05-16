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

    /**
     * 根据角色ID查询菜单列表
     * @param roleId 角色Id
     * @return 菜单列表
     */
    List<Menu> listMenu(Long roleId);

    /**
     * 分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 查询菜单列表
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<Menu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 查询
     * @return
     */
    List<MenuNode> treeList();

    /**
     * 更新
     * @param id
     * @param hidden
     * @return
     */
    boolean updateHidden(Long id, Integer hidden);
}
