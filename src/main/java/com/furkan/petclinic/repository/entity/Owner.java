package com.furkan.petclinic.repository.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data //<
@Table(name = "musteri")
public class Owner extends BaseEntity{

    @SequenceGenerator(name = "musteri_seq", sequenceName = "musteri_seq", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musteri_seq")
    @Id
    private Long id;

    private String ownerName;
    private String OwnerSurname;
    private String ownerPhone;
    private String ownerAddress;
    private String ownerEmail;

}
