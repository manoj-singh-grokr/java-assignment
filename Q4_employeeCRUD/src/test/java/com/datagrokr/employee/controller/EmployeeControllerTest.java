package com.datagrokr.employee.controller;

import com.datagrokr.employee.dao.EmployeeDAOHibernateImpl;
import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl service;

    private AutoCloseable autoCloseable;

    private EmployeeController underTest;


    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmployeeController(service);
    }

    @Test
    void viewHomePage() throws Exception {
        String url = "/";
        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
        verify(service).findAll();
    }

    @Test
    void isEmployeeSaved() throws Exception {
        Employee newEmployee = new Employee("Testing", "Testing", "testingnew@testing.com", 56200.0);

        String url = "/addEmployee";

        mockMvc.perform(
                post(url).flashAttr("employee", newEmployee)
        )
                .andExpect(status().is3xxRedirection());
        verify(service).save(newEmployee);
    }

    @Test
    void IsEmployeeFormDisplayed() throws Exception {
        String url="/addEmployeeForm";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    void getsEmployeeById() throws Exception {
        int id = 1;
        String url = "/employee/"+id;
        mockMvc.perform(get(url)).andExpect(status().isOk());
        verify(service).findById(id);
    }

    @Test
    void deleteEmployee() throws Exception {
        int id = 1;
        String url = "/delete/"+id;
        mockMvc.perform(get(url)).andExpect(status().isOk());
        verify(service).deleteById(id);
    }

//    @Test
//    void employeeUpdateForm() throws Exception {
//        int id=1;
//        Employee newEmployee = new Employee(id,"Man", "Tester", "man@test.com", 50000.0);
//        String url = "/employeeUpdateForm/"+id;
//        mockMvc.perform(
//                get(url)
//                .flashAttr("employee", newEmployee)
//        );
//    }

    @Test
    void isEmployeeUpdated() throws Exception {

    }

    @Test
    void mostBought() {
    }
}