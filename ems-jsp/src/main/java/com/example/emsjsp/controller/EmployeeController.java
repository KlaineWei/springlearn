package com.example.emsjsp.controller;

import com.example.emsjsp.entity.Employee;
import com.example.emsjsp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("delete")
    public String delete(Integer id){

        log.debug("删除的员工id:{}", id);
        employeeService.delete(id);
        return "redirect:/employee/list";
    }

    @RequestMapping("update")
    public String update(Employee employee){

        log.debug("员工id:{}", employee.getId());
        log.debug("员工姓名:{}", employee.getName());
        log.debug("员工工资:{}", employee.getSalary());
        log.debug("员工生日:{}", employee.getBirth());
        log.debug("员工性别:{}", employee.getGender());

        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("detail")
    public String detail(Integer id, Model model){

        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "updateEmp";
    }

    @RequestMapping("add")
    public String add(Employee employee){

        log.debug("员工姓名:{}", employee.getName());
        log.debug("员工工资:{}", employee.getSalary());
        log.debug("员工生日:{}", employee.getBirth());
        log.debug("员工性别:{}", employee.getGender());

        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("list")
    public String list(Model model){
        List<Employee> employees = employeeService.list();
        model.addAttribute("employees", employees);
        return "emplist";
    }
}
