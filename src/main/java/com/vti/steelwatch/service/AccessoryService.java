package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.AccessoryDto;
import com.vti.steelwatch.form.AccessoryCreateForm;
import com.vti.steelwatch.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    AccessoryDto create(AccessoryCreateForm form);
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto update(Long id,AccessoryUpdateForm form);

    void deleteById(Long id);
}
