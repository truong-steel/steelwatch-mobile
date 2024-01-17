package com.vti.steelwatch.dto;

import com.vti.steelwatch.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private Long id;
    private Role.Type type;
}
