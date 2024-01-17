package com.vti.steelwatch.controller;

import com.vti.steelwatch.dto.UserDto;
import com.vti.steelwatch.form.UserCreateForm;
import com.vti.steelwatch.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserCreateForm form){
        return userService.create(form);
    }
}
