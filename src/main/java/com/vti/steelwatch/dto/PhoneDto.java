package com.vti.steelwatch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PhoneDto {
    @JsonProperty("imei")
    private String pkImei;
    @JsonProperty("repairDate")
    private LocalDate pkRepairDate;
    private String customerName;
    private String type;
    private String catalog;
}
