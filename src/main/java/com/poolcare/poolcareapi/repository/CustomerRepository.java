package com.poolcare.poolcareapi.repository;

import java.util.List;
import com.poolcare.poolcareapi.domain.Customers;
import com.poolcare.poolcareapi.repository.PoolcareRepositoryCustom;
import com.poolcare.poolcareapi.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customers, Integer> { // , PoolcareRepositoryCustom

    // public List<Customers> getCustomersByCompanyId(int companyId) {
    //   Build criteria query and structure response
    // }

    // @Query(value = "SELECT * FROM poolcaredb.customers", nativeQuery=true)
    @Query(value = "SELECT * FROM poolcaredb.customers c WHERE c.company_id = :companyId", nativeQuery=true)
    List<Customers> getCustomersBycompanyId(int companyId);
}
