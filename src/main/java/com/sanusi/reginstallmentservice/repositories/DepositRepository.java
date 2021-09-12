package com.sanusi.reginstallmentservice.repositories;

import com.sanusi.reginstallmentservice.model.entities.Deposit;
import com.sanusi.reginstallmentservice.model.projections.DepositInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, String> {

    @Query(value = "select a.account_number as accountNumber, a.account_name as accountName, a.currency as currency, " +
            "d.saving_purpose as savingPurpose, d.first_amount as firstAmount, d.monthly_deposit_amount as monthlyDepositAmount, " +
            "d.tenor as tenor, d.final_balance as finalBalance, d.start_date as startDate, d.maturity_date as maturityDate" +
            " from deposit d " +
            "inner join account a on a.id = d.account_id " +
            "inner join account_type at on at.id = a.account_type_id " +
            "where a.is_deleted = 0 and d.is_deleted = 0 and at.is_deleted = 0", nativeQuery = true)
    public List<DepositInfo> getAllDeposito();

    @Query(value = "select a.account_number as accountNumber, a.account_name as accountName, a.currency as currency, " +
            "d.saving_purpose as savingPurpose, d.first_amount as firstAmount, d.monthly_deposit_amount as monthlyDepositAmount, " +
            "d.tenor as tenor, d.final_balance as finalBalance, d.start_date as startDate, d.maturity_date as maturityDate" +
            " from deposit d " +
            "inner join account a on a.id = d.account_id " +
            "inner join account_type at on at.id = a.account_type_id " +
            "where a.account_number = :accountNumber and " +
            "a.is_deleted = 0 and d.is_deleted = 0 and at.is_deleted = 0", nativeQuery = true)
    public List<DepositInfo> getAllDepositoByAccountNumber(@Param("accountNumber") String accountNumber);
}