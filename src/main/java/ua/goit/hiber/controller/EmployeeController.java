package ua.goit.hiber.controller;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.hiber.dao.interfaces.EmployeeDao;
import ua.goit.hiber.model.Employee;
import ua.goit.hiber.model.Position;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee(){
        Set<Employee> employees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setName("John");
        employee.setSurname("Jonson");
        employee.setBirthday(Date.valueOf("1995-05-25"));
        employee.setPhoneNumber("044-256-33-21");
        employee.setPosition(Position.MANAGER);
        employee.setSalary(1025.5);

        if(!employees.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
