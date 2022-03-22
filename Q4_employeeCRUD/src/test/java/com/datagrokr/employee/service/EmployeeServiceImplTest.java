package com.datagrokr.employee.service;

import com.datagrokr.employee.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    void findAll() {
        Employee test = new Employee("Harumi", "Testing", "harumi@testing.com", 56200.0);
        Employee test2 = new Employee("Jack", "Testing", "jack@testing.com", 54000.0);
        employeeService.save(test);
        employeeService.save(test2);
        List<Employee> result = employeeService.findAll();
        assertThat(result, hasSize(2));
    }

    @Test
    void findById() {
        Employee result = employeeService.findById(1);
        assertThat(result).isNotNull();
    }

    @Test
    void findByEmail() {
        String email = "harumi@testing.com";
        Employee result = employeeService.findByEmail(email);
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void save() {
        String email = "testingnew@testing.com";
        Employee test = new Employee("Testing", "Testing", "testingnew@testing.com", 56200.0);
        employeeService.save(test);
        Employee result = employeeService.findByEmail(email);
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void deleteById() {
        employeeService.deleteById(1);
        Employee result = employeeService.findById(1);
        System.out.println(result);
        assertThat(result).isNull();
    }
}