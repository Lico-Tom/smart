package com.smart.security.dto;

import com.smart.security.domain.Menu;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 *
 * @author lizhonghao
 * @date 2023/12/5
 */
@Getter
@Setter
public class MenuNode extends Menu {
    @SchemaProperty(name = "子级菜单")
    private List<MenuNode> children;
}
