package com.datagrokr.employee.dao;

import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        //return the employee
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee newEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newEmployee);
    }

    @Override
    public void deleteById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Employee where emp_id=:employeeId");
        theQuery.setParameter("employeeId", id);
        theQuery.executeUpdate();
    }

    @Override
    public Employee findByEmail(String email){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where(cb.equal(employee.get("email"), email));
        Employee result = entityManager.createQuery(query).getSingleResult();
        return result;
    }

    @Override
    public List<Sales> findMostBoughtBook() {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Sales> query = cb.createQuery(Sales.class);
            Root<Sales> root = query.from(Sales.class);
            Join<Object, Object> sales = root.join("book");
            query.select(sales.get("book_name")).where(cb.like(sales.get("genre"), "Software Architecture")).groupBy(sales.get("book_id"));
            List<Sales> result = entityManager.createQuery(query).getResultList();
            return result;
    }

}
