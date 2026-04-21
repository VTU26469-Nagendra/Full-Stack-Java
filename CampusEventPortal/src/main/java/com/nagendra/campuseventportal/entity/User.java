package com.nagendra.campuseventportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int vtuNo;

    private String name;
    private String registerNumber;
    private String department;
    private int year;
    private String phone;
    private String vtuEmail;
    private String password;

    private String role;

    public User() {}

    public int getVtuNo() {
        return vtuNo;
    }

    public void setVtuNo(int vtuNo) {
        this.vtuNo = vtuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVtuEmail() {
        return vtuEmail;
    }

    public void setVtuEmail(String vtuEmail) {
        this.vtuEmail = vtuEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}