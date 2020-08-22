package com.poolcare.poolcareapi.service;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.poolcare.poolcareapi.repository.CustomerRepository;
import com.poolcare.poolcareapi.repository.WorkOrderRepository;
import com.poolcare.poolcareapi.domain.Customers;
import com.poolcare.poolcareapi.domain.WorkOrders;
import com.poolcare.poolcareapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;
import org.springframework.stereotype.Service;

@Service
public class PoolCareService {

    private static final Logger LOG = LoggerFactory.getLogger(PoolCareService.class);
    // set up repository and call methods
    // @Qualifier("customerRepository")
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    public List<CustomerResponse> getCustomersByCompanyId(int companyId) {
        if (companyId <= 0) {
            // TODO: set up exception handling
            // throw new Error();
        }

        List<Customers> customers = customerRepository.getCustomersBycompanyId(companyId);
        List<CustomerResponse> result = new ArrayList<>();
        for (Customers customer : customers) {
            CustomerResponse res = new CustomerResponse();
            res.setFirstName(customer.getFirstName());
            res.setLastName(customer.getLastName());
            result.add(res);
        }
        return result;
    }

    public List<WorkOrder> getWorkOrdersByCompanyId(int companyId) {
        List<WorkOrders> workOrders = workOrderRepository.getByCompanyId(companyId);
        List<WorkOrder> result = new ArrayList<WorkOrder>();
        for (WorkOrders workOrder : workOrders) {
            WorkOrder wo = new WorkOrder();
            wo.setWorkOrderId(workOrder.getWorkOrderId());
            wo.setCompanyId(workOrder.getCompanyId());
            wo.setCustomerId(workOrder.getCustomerId());
            wo.setCreated(workOrder.getCreated());
            wo.setScheduled(workOrder.getScheduled());
            result.add(wo);
        }
        return result;
    }
}