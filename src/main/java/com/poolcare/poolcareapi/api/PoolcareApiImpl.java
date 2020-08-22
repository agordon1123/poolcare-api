package com.poolcare.poolcareapi.api;

import com.poolcare.poolcareapi.service.PoolCareService;
import java.util.List;
import java.util.ArrayList;
import com.poolcare.poolcareapi.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PoolcareApiImpl implements PoolcareApi {
    
    private static final Logger LOG = LoggerFactory.getLogger(PoolcareApiImpl.class);
    private ObjectMapper objectMapper;
    private PoolCareService poolcareService;

    // TODO: define a casing for poolcareService || poolCareService
    @Autowired
    public PoolcareApiImpl(ObjectMapper objectMapper, PoolCareService poolCareService) {
        this.objectMapper = objectMapper;
        this.poolcareService = poolCareService;
    }
    
    @Override
    public ResponseEntity<List<CustomerResponse>> getCustomersByCompanyId(Integer companyId) {
        
        List<CustomerResponse> response = this.poolcareService.getCustomersByCompanyId(companyId);
        // LOG.info("getCustomersByCompanyName object: {}", customerResponse);
        return new ResponseEntity<List<CustomerResponse>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddCustomerResponse> addCustomer(AddCustomerRequest request) {
        if (request.getFirstName() != null && request.getLastName() != null) {
            AddCustomerResponse response = new AddCustomerResponse();
            response.setFirstName("Alex");
            response.setLastName("Gordon");
            return new ResponseEntity<AddCustomerResponse>(response, HttpStatus.OK);
        }
        return new ResponseEntity<AddCustomerResponse>(new AddCustomerResponse(), HttpStatus.OK);
        // else {
        //     ErrorResponse error = new ErrorResponse();
        //     error.setMessage("Improper request body");
        //     return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
        // }
    }

    @Override
    public ResponseEntity<List<WorkOrder>> getWorkOrders(Integer companyId) {
        // TODO: complete exception handler
        if (companyId <= 0) {
            LOG.error("Company ID cannot be zero or negative");
        }
        List<WorkOrder> workOrders = poolcareService.getWorkOrdersByCompanyId(companyId);
        return new ResponseEntity<List<WorkOrder>>(workOrders, HttpStatus.OK);
    }
}