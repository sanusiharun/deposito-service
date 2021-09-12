package com.sanusi.reginstallmentservice.model.entities;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "account_type")
@Entity
@Data
@Builder
public class AccountType extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 3)
    private String code;
}