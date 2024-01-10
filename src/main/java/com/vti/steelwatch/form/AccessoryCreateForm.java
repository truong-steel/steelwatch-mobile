package com.vti.steelwatch.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryCreateForm {
    @NotBlank
    @Length(max=255)
    private String name;
    @PositiveOrZero
    @NotNull
    private String price;
    @NotBlank
    @Length(max=255)
    private String damagedStatus;
    @NotBlank
    @Length(max=255)
    private String repairStatus;
    @NotBlank
    @Length(max=255)
    private String imei;
    @NotNull
    @PastOrPresent
    private LocalDate repairDate;
}
