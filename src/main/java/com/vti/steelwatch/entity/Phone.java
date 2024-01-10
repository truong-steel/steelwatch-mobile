package com.vti.steelwatch.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="phone")
public class Phone {
    @EmbeddedId
    private PrimaryKey pk;
    @Column(name="customer_name",nullable = false)
    private String customerName;
    @Column(name="type",nullable = false)
    private String type;
    @Column(name="catalog",nullable = false)
    private String catalog;
    @OneToMany(mappedBy = "phone")
    private List<Accessory> accessories;
    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class PrimaryKey {
        @Column(name="imei",unique= true)
        private String imei;
        @Column(name="repair_date")
        private LocalDate repairDate;
    }
}
