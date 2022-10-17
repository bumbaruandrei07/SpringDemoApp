package com.spring.app.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

// echivalent cu @Service
@Component
public class EmployeeService implements IEmployeeService {

    //dependinta de tip EmployeeRepository
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    //inregistrarea (CREATE) unui nou angajat in baza de date
    @Override
    public void createEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employeeUpdated = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with id %s doesn't exist", id)));
        employeeUpdated.setFirstName(employee.getFirstName());
        employeeUpdated.setLastName(employee.getLastName());
        employeeUpdated.setAge(employee.getAge());
        employeeUpdated.setAddress(employee.getAddress());
        employeeUpdated.setEmailAddress(employee.getEmailAddress());
        employeeUpdated.setRole(employee.getRole());

        employeeRepository.save(employeeUpdated);
    }

    public void deleteEmployee(Long id){
        boolean isExistEmployee = employeeRepository.existsById(id);
        if(!isExistEmployee){
            throw new IllegalStateException(String.format("Employee with id %s doesn't exist!", id));
        }
        employeeRepository.deleteById(id);
    }

}
