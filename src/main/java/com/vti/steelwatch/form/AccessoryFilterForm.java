package com.vti.steelwatch.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryFilterForm {
    private String search;
    private LocalDate minCreateDate;
    private LocalDate maxCreateDate;
}
