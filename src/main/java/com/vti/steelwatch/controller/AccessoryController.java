package com.vti.steelwatch.controller;

import com.vti.steelwatch.dto.AccessoryDto;
import com.vti.steelwatch.form.AccessoryCreateForm;
import com.vti.steelwatch.form.AccessoryUpdateForm;
import com.vti.steelwatch.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccessoryController {
    private final AccessoryService accessoryService;
    @PostMapping("/api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody @Valid AccessoryCreateForm form){
        return accessoryService.create(form);
    }
    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }
    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(@PathVariable("id") Long id ,@RequestBody @Valid AccessoryUpdateForm form){
        return accessoryService.update(id,form);
    }
    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        accessoryService.deleteById(id);
    }
}
