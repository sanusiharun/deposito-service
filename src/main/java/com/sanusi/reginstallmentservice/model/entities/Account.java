package com.sanusi.reginstallmentservice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "account")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "account_number", unique = true, length = 20)
    private String accountNumber;

    @Column(name = "account_name", length = 50)
    private String accountName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "cif", length = 11)
    private String cif;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "currency", length = 3)
    private String currency;

    @Column(name = "account_type_id")
    private String accountTypeId;
}