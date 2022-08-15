package com.furkan.petclinic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tblpet")
@Entity
public class Pet extends BaseEntity{

    @Id
    @SequenceGenerator(name ="pet_seq", sequenceName = "pet_seq",initialValue = 200,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long petId;
    private String petName;
    private String petType;
    private String PetFamily;
    private Long petAge;





}
