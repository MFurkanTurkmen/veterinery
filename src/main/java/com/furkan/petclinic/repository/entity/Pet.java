package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tblpet")
public class Pet extends BaseEntity{

    @Id
    @SequenceGenerator(name ="pet_seq", sequenceName = "pet_seq",initialValue = 200,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long petId;
    private String petName;
    private String petType;
    private String PetFamily;
    private Long petAge;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId")
    public Owner owner;



}
