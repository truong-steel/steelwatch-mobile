package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.AccessoryDto;
import com.vti.steelwatch.entity.Accessory;
import com.vti.steelwatch.entity.Phone;
import com.vti.steelwatch.form.AccessoryCreateForm;
import com.vti.steelwatch.form.AccessoryUpdateForm;
import com.vti.steelwatch.form.PhoneFilterForm;
import com.vti.steelwatch.repository.AccessoryRepository;
import com.vti.steelwatch.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final PhoneRepository phoneRepository;
    private final ModelMapper modelMapper;
    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var accessory = modelMapper.map(form , Accessory.class);
        var pk = modelMapper.map(form, Phone.PrimaryKey.class);
        var phone = phoneRepository.findById(pk).get();
        accessory.setPhone(phone);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory,AccessoryDto.class);
    }

    @Override
    public Page<AccessoryDto> findAll( Pageable pageable) {

       return accessoryRepository.findAll(pageable).map(accessory-> modelMapper.map(accessory,AccessoryDto.class));
    }

    @Override
    public AccessoryDto update(Long id, AccessoryUpdateForm form) {
        var accessory = accessoryRepository.findById(id).get();
        modelMapper.map(form,accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
