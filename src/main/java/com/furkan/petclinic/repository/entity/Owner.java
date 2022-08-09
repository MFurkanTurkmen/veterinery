package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data // get,set,tostring oluşturur
@Table(name = "owner")
public class Owner extends BaseEntity{

    @SequenceGenerator(name = "musteri_seq", sequenceName = "musteri_seq", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musteri_seq")
    @Id
    private Long ownerId;
    private String ownerName;
    private String OwnerSurname;
    private String ownerPhone;
    private String ownerAddress;
    private String ownerEmail;

    /**
     * one to many
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Pet> pets;
    */



}
