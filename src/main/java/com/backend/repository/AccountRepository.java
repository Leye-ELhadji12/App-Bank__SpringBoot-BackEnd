package com.backend.repository;

import com.backend.dto.AccountDTO;
import com.backend.dto.AccountLitDTO;
import com.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query( "SELECT NEW com.backend.dto.AccountLitDTO(" +
            "a.id, a.balance, a.createdate) " +
            "FROM Account a WHERE a.customer.id = :customerId")
    List<AccountLitDTO> listAccountTypeByCustomerId(@Param("customerId") int customerId);



}
