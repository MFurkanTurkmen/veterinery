package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "/user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String userSurname;
    private String userPhone;
}
