package com.vti.steelwatch.controller;

import com.vti.steelwatch.dto.PhoneDto;
import com.vti.steelwatch.entity.Phone;
import com.vti.steelwatch.form.PhoneCreateForm;
import com.vti.steelwatch.form.PhoneFilterForm;
import com.vti.steelwatch.form.PhoneUpdateForm;
import com.vti.steelwatch.service.PhoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("*")
public class PhoneController {
    private final PhoneService phoneService;
    @PostMapping("/api/v1/phones")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneDto create(@RequestBody @Valid PhoneCreateForm form){
       return phoneService.create(form);
    }
    @GetMapping("/api/v1/phones")
    public Page<PhoneDto> findAll(PhoneFilterForm form ,Pageable pageable){
        return phoneService.findAll(form,pageable);
    }
    @PutMapping("/api/v1/phones")
    public PhoneDto update(@RequestBody @Valid PhoneUpdateForm form){
        return phoneService.update(form);
    }
    @DeleteMapping("/api/v1/phones")
    public void deleteById(@RequestBody Phone.PrimaryKey pk){
        phoneService.deleteById(pk);
    }
}
