package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    //nesneyi networkten taşıma veya liste yazıp okuma
    private Date createdDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;


}
