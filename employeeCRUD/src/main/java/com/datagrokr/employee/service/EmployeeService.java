package com.datagrokr.employee.service;

import com.datagrokr.employee.entity.Book;
import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public void save(Employee employee);
    public void deleteById(Integer id);
    public Employee findByEmail(String email);
    public List<Sales> findMostBoughtBook();
}
