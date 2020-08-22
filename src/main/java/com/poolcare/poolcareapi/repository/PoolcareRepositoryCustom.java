package com.poolcare.poolcareapi.repository;

import java.util.List;
import java.util.ArrayList;
import com.poolcare.poolcareapi.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: testing to see if I need a repository for every domain type accessable through jpa
@Repository
public class PoolcareRepositoryCustom {
    
    // @PersistenceContext(unitName = "pcPersistenceUnit")
    // private EntityManager entityManager;

    // public List<Customers> getCustomersByCompanyId(int companyId) {
    //     List<Customers> result = new ArrayList<Customers>();
    //     // TODO: single naming convention in domain
    //     Customers customer = new Customers();
    //     customer.setFirstName("Marvin");
    //     customer.setLastName("Gordon");
    //     result.add(customer);
    //     return result;
    // }

}