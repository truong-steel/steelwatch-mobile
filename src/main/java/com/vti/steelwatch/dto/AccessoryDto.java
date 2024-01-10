package com.vti.steelwatch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryDto {
    private Long id;
    private String name;
    private String price;
    private String damagedStatus;
    private String repairStatus;
    @JsonProperty("imei")
    private String phonePkImei;
    @JsonProperty("repairDate")
    private LocalDate phonePkRepairDate;
}
