package com.furkan.petclinic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbluser")
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 300, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long UserId;

    private String userName;
    private String userSurname;
    private String userPhone;
}
