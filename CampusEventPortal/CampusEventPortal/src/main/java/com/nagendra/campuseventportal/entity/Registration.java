package com.nagendra.campuseventportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String eventName;

    private String vtuNo;
    private String name;
    private String registerNumber;
    private String department;
    private String year;
    private String phone;
    private String vtuEmail;

    public Registration() {
    }

    // ✅ ID
    public int getId() {
        return id;
    }

    // ✅ EVENT NAME
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // ✅ VTU NO (FIXED)
    public String getVtuNo() {
        return vtuNo;
    }

    public void setVtuNo(String vtuNo) {
        this.vtuNo = vtuNo;
    }

    // ✅ NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ REGISTER NUMBER
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    // ✅ DEPARTMENT
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // ✅ YEAR (FIXED)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    // ✅ PHONE
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ✅ EMAIL
    public String getVtuEmail() {
        return vtuEmail;
    }

    public void setVtuEmail(String vtuEmail) {
        this.vtuEmail = vtuEmail;
    }
}