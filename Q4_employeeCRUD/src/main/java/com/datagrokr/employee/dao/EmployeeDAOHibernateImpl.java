package com.datagrokr.employee.dao;

import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;
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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where(cb.equal(employee.get("emp_id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void save(Employee newEmployee) {
        entityManager.persist(newEmployee);
    }

    @Override
    public void deleteById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.
                createCriteriaDelete(Employee.class);
        Root<Employee> e = delete.from(Employee.class);
        delete.where(cb.equal(e.get("emp_id"), id));
        entityManager.createQuery(delete).executeUpdate();
    }

    @Override
    public Employee findByEmail(String email){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where(cb.equal(employee.get("email"), email));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Sales> findMostBoughtBook() {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Sales> query = cb.createQuery(Sales.class);
            Root<Sales> root = query.from(Sales.class);
            Join<Object, Object> sales = root.join("book");
            query.select(sales.get("book_name")).where(cb.like(sales.get("genre"), "Software Architecture")).groupBy(sales.get("book_id")).orderBy(cb.desc(cb.count(query.from(Sales.class))));
            return entityManager.createQuery(query).getResultList();
    }

}
