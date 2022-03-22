package com.datagrokr.multipledatabases.dao.firstdatabaserepo;

import com.datagrokr.multipledatabases.entity.firstdatabase.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("firstSales")
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
