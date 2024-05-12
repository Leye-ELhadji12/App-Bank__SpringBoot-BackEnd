package com.backend.repository;

import com.backend.dto.OperationCustomerDTO;
import com.backend.entity.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByAccountId(String accountId);
    Page<Operation> findByAccountId(String accountId, Pageable pageable);

}
