package com.vti.steelwatch.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class PhoneUpdateForm {
    @NotBlank
    @Length(max=255)
    private String imei;
    @NotNull
    @PastOrPresent
    private LocalDate repairDate;
    @NotBlank
    @Length(max=255)
    private String customerName;
    @NotBlank
    @Length(max=255)
    private String type;
    @NotBlank
    @Length(max=255)
    private String catalog;
}
