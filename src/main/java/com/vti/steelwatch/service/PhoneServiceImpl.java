package com.vti.steelwatch.service;

import com.vti.steelwatch.dto.PhoneDto;
import com.vti.steelwatch.entity.Phone;
import com.vti.steelwatch.form.PhoneCreateForm;
import com.vti.steelwatch.form.PhoneFilterForm;
import com.vti.steelwatch.form.PhoneUpdateForm;
import com.vti.steelwatch.repository.PhoneRepository;
import com.vti.steelwatch.specification.PhoneSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneServiceImpl implements PhoneService{
    private final PhoneRepository phoneRepository;
    private final ModelMapper modelMapper;
    @Override
    public PhoneDto create(PhoneCreateForm form) {
        var phone = modelMapper.map(form , Phone.class);
        var pk = modelMapper.map(form ,Phone.PrimaryKey.class);
        phone.setPk(pk);
        var savedPhone = phoneRepository.save(phone);
        return modelMapper.map(savedPhone , PhoneDto.class);
    }

    @Override
    public Page<PhoneDto> findAll(PhoneFilterForm form,Pageable pageable) {
        var spec = PhoneSpecification.buildSpec(form);
       return phoneRepository.findAll(pageable).map(phone->modelMapper.map(phone, PhoneDto.class));
    }

    @Override
    public void deleteById(Phone.PrimaryKey pk) {
        phoneRepository.deleteById(pk);
    }

    @Override
    public PhoneDto update(PhoneUpdateForm form) {
        var pk = modelMapper.map(form , Phone.PrimaryKey.class);
        var phone = phoneRepository.findById(pk).get();
        modelMapper.map(form , phone);
        var savedPhone = phoneRepository.save(phone);
        return modelMapper.map(savedPhone, PhoneDto.class);
    }
}
