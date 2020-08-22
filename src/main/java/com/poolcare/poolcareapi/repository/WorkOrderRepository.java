package com.poolcare.poolcareapi.repository;

import java.util.List;
import com.poolcare.poolcareapi.domain.WorkOrders;
import com.poolcare.poolcareapi.repository.PoolcareRepositoryCustom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("workOrderRepository")
public interface WorkOrderRepository extends JpaRepository<WorkOrders, Integer> {

    @Query(value = "SELECT * FROM poolcaredb.work_orders WHERE company_id = :companyId", nativeQuery = true)
    public List<WorkOrders> getByCompanyId(int companyId);
    
}