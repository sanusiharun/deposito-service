package com.sanusi.reginstallmentservice.model.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "deposit")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "account_id", length = 36)
    private String accountId;

    @Column(name = "tenor", length = 3)
    private Integer tenor;

    @Column(name = "saving_purpose", length = 255)
    private String savingPurpose;

    @Column(name = "first_amount")
    private BigDecimal firstAmount;

    @Column(name = "monthly_deposit_amount")
    private BigDecimal monthlyDepositAmount;

    @Column(name = "final_balance")
    private BigDecimal finalBalance;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "maturity_date")
    private Date maturityDate;
}