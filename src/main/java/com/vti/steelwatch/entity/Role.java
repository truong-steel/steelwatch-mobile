package com.vti.steelwatch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="role")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Type type ;

    public enum Type {
        ADMIN , USER
    }

}
