package com.sanusi.reginstallmentservice.repositories;

import com.sanusi.reginstallmentservice.model.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, String> {
}