package com.vti.steelwatch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name="accessory")
public class Accessory {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="price",nullable = false)
    private String price;
    @Column(name="damaged_status",nullable = false)
    private String damagedStatus;
    @Column(name="repair_status",nullable = false)
    private String repairStatus;

    @ManyToOne
    @JoinColumns(value= {
            @JoinColumn(name="imei",referencedColumnName = "imei"),
            @JoinColumn(name="repair_date",referencedColumnName = "repair_date")
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Phone phone;
}
