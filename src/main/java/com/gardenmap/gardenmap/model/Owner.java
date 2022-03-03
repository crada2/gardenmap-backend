package com.gardenmap.gardenmap.model;

import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

import javax.persistence.*;

@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;

    @Column(unique = true)
    private String email;
    private String password;
    private Long phone;
    private String address;
    public Owner(){

    }


}
