package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.PhoneDto;
import com.vti.steelwatch.entity.Phone;
import com.vti.steelwatch.form.PhoneCreateForm;
import com.vti.steelwatch.form.PhoneFilterForm;
import com.vti.steelwatch.form.PhoneUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    PhoneDto create(PhoneCreateForm form);
    Page<PhoneDto> findAll(PhoneFilterForm form, Pageable pageable);
    void deleteById(Phone.PrimaryKey pk);
    PhoneDto update(PhoneUpdateForm form);
}








