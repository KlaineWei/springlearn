package com.example.emsjsp.entity;

import java.util.Date;

public class Employee {

    private Integer id;
    private String name;
    private Date birth;
    private Double salary;
    private Boolean gender;

    public Employee() {
    }

    public Employee(Integer id, String name, Date birth, Double salary, Boolean gender) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.salary = salary;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
