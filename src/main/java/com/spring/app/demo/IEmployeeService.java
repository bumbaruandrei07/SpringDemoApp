package com.spring.app.demo;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getEmployees();

    //metoda de creare a unui angajat

    void createEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

}
