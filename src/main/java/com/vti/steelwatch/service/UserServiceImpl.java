package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.UserDto;
import com.vti.steelwatch.entity.Role;
import com.vti.steelwatch.entity.User;
import com.vti.steelwatch.form.UserCreateForm;
import com.vti.steelwatch.repository.RoleRepository;
import com.vti.steelwatch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto create(UserCreateForm form) {
        var user = modelMapper.map(form, User.class);
        var role = roleRepository.findByType(Role.Type.USER);
        user.setRoles(Set.of(role));
        var encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        var savedUser = userRepository.save(user);

        return modelMapper.map(savedUser , UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        var authorities = new ArrayList<GrantedAuthority>();
        var roles = user.getRoles();
        for (Role role : roles) {
            var authority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(authority);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
