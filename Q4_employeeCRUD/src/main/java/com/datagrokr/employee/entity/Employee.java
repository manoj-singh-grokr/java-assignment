package com.datagrokr.employee.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer emp_id;
    private String emp_name;
    private String designation;
    @Column(name="email", unique = true)
    private String email;
    private Double salary;

    public Employee(){
    }

    public Employee(String emp_name, String designation, String email, Double salary) {
        this.emp_name = emp_name;
        this.designation = designation;
        this.email = email;
        this.salary = salary;
    }

    public Employee(Integer emp_id, String emp_name, String designation, String email, Double salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.email = email;
        this.salary = salary;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
