package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pet")
public class Pet extends BaseEntity{

    @Id
    @SequenceGenerator(name ="pet_seq", sequenceName = "pet_seq",initialValue = 200,allocationSize = 1)
    @GeneratedValue
    private Long petId;
    private String petName;
    private String petType;
    private String PetFamily;
    private Long petAge;

   /**
    * Many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId")
    public Owner owner;
    */


}
