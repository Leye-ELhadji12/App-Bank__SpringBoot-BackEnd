package com.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data @Builder @AllArgsConstructor
public class OperationCustomerDTO {

    private Long customerId;
    private Long operationId;
    private String accountId;
    private double amount;
    private String description;
    private Date operationdate;
    private String typeOp;


}
