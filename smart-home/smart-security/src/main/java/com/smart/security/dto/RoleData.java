package com.smart.security.dto;

import com.smart.security.domain.Role;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lico-Tom
 * 2023/12/12 0:41
 * @version V1.0
 */
@Builder
@Data
public class RoleData implements Serializable {

    private List<Role> roles;
    private String introduction;
    private String avatar;
    private String name;
}
