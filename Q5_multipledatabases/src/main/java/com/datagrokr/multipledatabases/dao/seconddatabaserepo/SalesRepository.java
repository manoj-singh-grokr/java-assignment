package com.datagrokr.multipledatabases.dao.seconddatabaserepo;

import com.datagrokr.multipledatabases.entity.seconddatabase.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("secondSales")
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
