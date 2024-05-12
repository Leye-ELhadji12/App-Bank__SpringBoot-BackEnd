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

    @Query("SELECT NEW com.backend.dto.OperationCustomerDTO(c.id, op.id, a.id, op.amount, op.description, op.operationdate, op.typeOp) " +
            "FROM Operation op " +
            "JOIN op.account a " +
            "JOIN a.customer c " +
            "WHERE c.id = :customerId")
    List<OperationCustomerDTO> getAllHistoriesByCustomerId(@Param("customerId") Long customerId, Pageable pageable);
}
