package com.spring.app.demo;


import org.springframework.data.jpa.repository.JpaRepository;

//o vom folosi pentru a interactiona integral cu baza de date -> extends JpaRepository<Type, ID>
//type-ul este pentru ce entitate va fi folosit -> Employee si Long pentru ID (definit astfel in cadrul clasei Employee)
//vom folosi metodele deja declarate in cadrul interfetei JpaRepository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
