package com.vti.steelwatch.repository;

import com.vti.steelwatch.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByType(Role.Type type);
}
