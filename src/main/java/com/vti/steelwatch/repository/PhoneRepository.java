package com.vti.steelwatch.repository;

import com.vti.steelwatch.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhoneRepository extends JpaRepository<Phone, Phone.PrimaryKey> , JpaSpecificationExecutor<Phone> {
}
