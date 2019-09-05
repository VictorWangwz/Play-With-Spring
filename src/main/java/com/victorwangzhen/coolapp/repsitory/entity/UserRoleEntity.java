package com.victorwangzhen.coolapp.repsitory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
@Data
public class UserRoleEntity {

    @Id
    @GeneratedValue
    private String id;

    @Column(length = 32)
    private String uid;

    @Column(length = 32)
    private String rid;
}
