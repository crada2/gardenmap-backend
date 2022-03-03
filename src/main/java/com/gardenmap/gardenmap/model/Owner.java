//package com.gardenmap.gardenmap.model;
//
//import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="owner")
//public class Owner {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//    private String lastname;
//
//    @Column(unique = true)
//    private String email;
//    private String password;
//    private Long phone;
//    private String address;
//    public Owner(){
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Long getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Long phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
