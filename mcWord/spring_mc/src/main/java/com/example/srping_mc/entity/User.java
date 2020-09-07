package com.example.srping_mc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "userLogin")

@Entity
@Data
public class User {
    
    @Id
    //添加完成后 user.set 不需要加id即可
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String userName ;
    private String password;

}