package com.datagrokr.employee.controller;

import com.datagrokr.employee.dao.EmployeeDAOHibernateImpl;
import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl service;

    @MockBean
    private EmployeeDAOHibernateImpl employeeRepository;

    @BeforeEach
    void setUp(){

    }

    @Test
    void viewHomePage() throws Exception {
        List<Employee> listEmployees= new ArrayList<Employee>();
        listEmployees.add(new Employee(1, "Man", "Tester", "man@test.com", 50000.0));
        listEmployees.add(new Employee(2, "Hate", "Tester", "hate@test.com", 50000.0));
        Mockito.when(service.findAll()).thenReturn(listEmployees);
        String url = "/";
        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }

    @Test
    void isEmployeeSaved() throws Exception {
        Employee newEmployee = new Employee(1, "Man", "Tester", "man@test.com", 50000.0);

        String url = "/addEmployee";

        mockMvc.perform(
                post(url)
                .param("emp_id", "1")
                .param("emp_name", newEmployee.getEmp_name())
                .param("designation", newEmployee.getDesignation())
                .param("email", newEmployee.getEmail())
                .param("salary", "58000.0")
        )
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void IsEmployeeFormDisplayed() throws Exception {
        String url="/addEmployeeForm";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    void getsEmployeeById() throws Exception {
        int id = 1;
        String url = "/employee/"+8;
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    void deleteEmployee() {

    }

//    @Test
//    void employeeUpdateForm() throws Exception {
//        Employee newEmployee = new Employee(1, "Man", "Tester", "man@test.com", 50000.0);
//        int id=1;
//        String url = "/updateEmployeeForm/"+id;
//        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//    }

    @Test
    void updateEmployee() {
    }

    @Test
    void mostBought() {
    }
}