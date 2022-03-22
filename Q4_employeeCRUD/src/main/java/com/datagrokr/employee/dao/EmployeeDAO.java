package com.datagrokr.employee.dao;

import com.datagrokr.employee.entity.Book;
import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public void save(Employee newEmployee);
    public void deleteById(Integer id);
    public Employee findByEmail(String email);

    public List<Sales> findMostBoughtBook();
}
