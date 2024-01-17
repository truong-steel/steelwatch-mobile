package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.UserDto;
import com.vti.steelwatch.form.UserCreateForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto create(UserCreateForm form);
}
