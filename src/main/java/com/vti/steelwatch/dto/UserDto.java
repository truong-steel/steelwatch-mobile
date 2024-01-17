package com.vti.steelwatch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<RoleDto> roles;
}
