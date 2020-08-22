package com.poolcare.poolcareapi.repository;

import com.poolcare.poolcareapi.domain.Companies;
import com.poolcare.poolcareapi.repository.PoolcareRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Companies, Integer> { // , PoolcareRepositoryCustom
    
}
