package com.vti.steelwatch.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class PhoneCreateForm {
    @NotBlank(message="{phone.imei.NotBlank.message}")
    @Length(max=255,message="{phone.imei.Length.message}")
    private String imei;
    @NotNull(message="{phone.repairDate.NotNull.message}")
    @PastOrPresent(message="{phone.repairDate.PastOrPresent.message}")
    private LocalDate repairDate;
    @NotBlank(message="{phone.customerName.NotBlank.message}")
    @Length(max=255,message="{phone.customerName.Length.message}")
    private String customerName;
    @NotBlank(message="{phone.type.NotBlank.message}")
    @Length(max=255,message="{phone.type.Length.message}")
    private String type;
    @NotBlank(message="{phone.color.NotBlank.message}")
    @Length(max=255,message="{phone.color.Length.message}")
    private String catalog;
}
