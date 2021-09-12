package com.sanusi.reginstallmentservice.repositories;

import com.sanusi.reginstallmentservice.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    public Optional<Account> findByAccountNumber(String accountNumber);
}