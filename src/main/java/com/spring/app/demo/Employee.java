package com.spring.app.demo;


//JSON - transmiterea de obiecte complexe, JavaScript Object Notation
//ne permite sa transmitem obiecte prin intermediul protocolului HTTP si sa fie interpretate de catre client
//toate atributele clasei for fi mapate pe campurile din JSON
//JSON este formatul in standard pentru REST API, obiectul va fi afisat in browser sub forma unui json
//avem nevoie de un obiect pe care sa-l returnam ca obiect in cadrul unei metode, clientul va primi in format JSON
//Postman este tool-ul de baza pentru testat aplicatii de tip REST (Representational State Transfer)

//pentru a transforma clasa intr-o tabela trebuie sa adaugam 2 adnotari, @entity si @table (numele pe care il va avea tabela generata in baza de date)
//automat ni se va sugera sa adaugam un id
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    //este autoincrementat cu fiecare noua inregistrare
    //hibernate creaza tabela in mod automat
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "employee_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id; //Long pentru ca intr-o aplicatie reala ajung la numere destul de mari
    private String firstName;


    private String lastName;
    private int age;
    private String emailAddress;
    private String address;
    private String role;


    public Employee(){

    }

    public Employee(String firstName, String lastName, int age, String emailAddress, String address, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.address = address;
        this.role = role;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
