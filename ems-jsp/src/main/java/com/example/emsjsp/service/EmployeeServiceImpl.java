package com.example.emsjsp.service;

import com.example.emsjsp.dao.EmployeeDao;
import com.example.emsjsp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee){
        employeeDao.update(employee);
    }

    @Override
    public Employee findById(Integer id){
        return employeeDao.findById(id);
    }

    @Override
    public void add(Employee employee){
        employeeDao.add(employee);
    }

    @Override
    public  List<Employee> list(){
        return employeeDao.list();
    }
}
