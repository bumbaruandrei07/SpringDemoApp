package com.spring.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//vom folosi repository-ul direct in controller-ul nostru
@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeesController {

    //repository-ul a fost instantiat automat de catre spring prin Dependency Injection pus la dispozitie tot de Spring,
    // deoarece nu avem "new", ci doar este declarat si instantiat prin
    //Depedency Injection + IoC
    private final EmployeeRepository employeeRepository;


    //este un component, Spring o aduce in container-ul de IoC si o instantiaza.
    // Trebuie sa adaugam @Component in dreptul clasei MyClass pentru a fi recunoscuta ca si componenta
    // Varianta 2 -  o adnotam cu @Autowired si o stergem din constructor, nu mai este final
   // @Autowired odalitate de Depedency Injection direct printr-un camp, nu este recomandata pt. ca foloseste reflection
    //cea mai buna practica este sa olosim contructorul
    // private MyClass myClass;
     private final MyClass myClass;

    //constructor injection -> injectam dependintele in cadrul constructorului
    //putem sa adnotam constructorul cu @Autowired, dar nu este obligatoriu, dar la field injection este mandatory,
    // cand nu avem dependinta injectata in constructor

    @Autowired
    public EmployeesController(EmployeeRepository employeeRepository, MyClass myClass) {
        this.employeeRepository = employeeRepository;
        this.myClass = myClass;
    }

    //citim datele despre un angajat
    @GetMapping(path = "/firstEmployee")
    public Employee getEmployee() {
        return new Employee("Andrei", "Bumbaru", 20, "bogdan.petre@gmail.com", "Bucuresti", "Junior Java Developer");
    }

    @GetMapping(path = "/list")
    public List<Employee> getListOfEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Employee e1 = new Employee("Ana", "Petre", 22, "ana.petre@gmail.com", "Bucuresti", "Junior Java Developer");
        Employee e2 = new Employee("Laurentiu", "Mihai", 24, "laurentiu.mihai@gmail.com", "Bucuresti", "Junior Java Developer");
        employeeList.add(e1);
        employeeList.add(e2);
        return employeeList;
    }

    //vom injecta EmployeeRepository folosind constructorul
    //folosim repository-ul pentru a citi toti angajatii din baza de date (datorita JpaRepository)

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //apelam metoda specifica din clasa noastra componenta
    @GetMapping(path = "/hello")
    public String sayHello(){
       return myClass.sayHello();
    }


}
