package com.datagrokr.employee.service;

import com.datagrokr.employee.dao.EmployeeDAO;
import com.datagrokr.employee.entity.Book;
import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee findByEmail(String email) {
        return employeeDAO.findByEmail(email);
    }

    @Override
    public List<Sales> findMostBoughtBook() {
        return employeeDAO.findMostBoughtBook();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeDAO.deleteById(id);
    }
}
