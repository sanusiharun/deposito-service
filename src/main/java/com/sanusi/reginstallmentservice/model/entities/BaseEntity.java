package com.sanusi.reginstallmentservice.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    @Column(name = "is_deleted", nullable = false, columnDefinition = "BIT", length = 1)
    private Boolean isDeleted;

    @Column(name = "updated_date")
    private Date updatedDate;
}