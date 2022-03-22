package com.datagrokr.employee.dao;

import com.datagrokr.employee.entity.Employee;
import org.assertj.core.api.AssertionsForClassTypes;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeDAOHibernateImplTest {

//    @MockBean
//    private EntityManager entityManager;
//
//    @MockBean
//    private Session session;
//
//    @MockBean
//    private CriteriaBuilder cb;
//
//    @Mock
//    CriteriaQuery<Employee> cq;
//
//    @Mock
//    Root<Employee> rootEmployeeEntity;

    @Autowired
    private EmployeeDAOHibernateImpl underTest;


    @BeforeEach
    void setUp() throws Exception{

    }
    @Test
    void findAll() {
        Employee test = new Employee("Harumi", "Testing", "harumi@testing.com", 56200.0);
        Employee test2 = new Employee("Jack", "Testing", "jack@testing.com", 54000.0);
        underTest.save(test);
        underTest.save(test2);
        List<Employee> result = underTest.findAll();
        System.out.println(result);
//
//        when(entityManager.getCriteriaBuilder()).thenReturn(cb);
//        when(cb.createQuery(Employee.class)).thenReturn(cq);
//        when(cq.from(Employee.class)).thenReturn(rootEmployeeEntity);
    }

    @Test
    void findById() {
        Employee result = underTest.findById(1);
        AssertionsForClassTypes.assertThat(result).isNotNull();
    }

    @Test
    void findByEmail() {
        String email = "harumi@testing.com";
        Employee result = underTest.findByEmail(email);
        System.out.println(result);
        AssertionsForClassTypes.assertThat(result).isNotNull();
    }

    @Test
    void save() {
        String email = "testingnew@testing.com";
        Employee test = new Employee("Testing", "Testing", "testingnew@testing.com", 56200.0);
        underTest.save(test);
        Employee result = underTest.findByEmail(email);
        System.out.println(result);
        AssertionsForClassTypes.assertThat(result).isNotNull();
    }

    @Test
    void deleteById() {
        underTest.deleteById(1);
        Employee result = underTest.findById(1);
        System.out.println(result);
        AssertionsForClassTypes.assertThat(result).isNull();
    }
}