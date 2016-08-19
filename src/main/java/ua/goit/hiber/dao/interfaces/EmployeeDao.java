package ua.goit.hiber.dao.interfaces;


import ua.goit.hiber.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save (Employee employee);
    void remove (Employee employee);
    Employee load(Long id);
    Employee findByName(String name);
    List<Employee> findAll();
}
