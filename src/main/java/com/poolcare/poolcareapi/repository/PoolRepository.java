package com.poolcare.poolcareapi.repository;

import com.poolcare.poolcareapi.domain.Pools;
import com.poolcare.poolcareapi.repository.PoolcareRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("poolRepository")
public interface PoolRepository extends JpaRepository<Pools, Integer> {
    
}