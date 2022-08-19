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
@Table(name = "tblowner")
@Entity
public class Owner extends BaseEntity{

    @SequenceGenerator(name = "musteri_seq", sequenceName = "musteri_seq", initialValue = 400, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musteri_seq")
    @Id
    @JoinColumn(name = "ownerId")
    Long ownerId;
    private String ownerName;
    private String ownerSurname;

    private String ownerPassword;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;
    @OneToMany(mappedBy = "owner")
     List<Pet> petList;
}
