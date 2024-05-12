package com.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data @Builder
public class AccountLitDTO {
    private String id;
    private double balance;
    private Date createdate;
}
