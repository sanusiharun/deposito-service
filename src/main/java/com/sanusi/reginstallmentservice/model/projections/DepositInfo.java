package com.sanusi.reginstallmentservice.model.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface DepositInfo {
    String getAccountNumber();

    String getAccountName();

    String getCurrency();

    BigDecimal getFinalBalance();

    BigDecimal getFirstAmount();

    BigDecimal getMonthlyDepositAmount();

    Integer getTenor();

    Date getStartDate();

    Date getMaturityDate();
}
