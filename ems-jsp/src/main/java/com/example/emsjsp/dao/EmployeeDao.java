package com.example.emsjsp.dao;

import com.example.emsjsp.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> list();

    void add(Employee employee);

    Employee findById(Integer id);

    void update(Employee employee);

    void delete(Integer id);
}
