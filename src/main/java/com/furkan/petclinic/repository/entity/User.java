package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbluser")
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long userId;

    private String userName;
    private String userSurname;
    private String userPhone;
    private String userEmail;
    private String userPassword;
}
