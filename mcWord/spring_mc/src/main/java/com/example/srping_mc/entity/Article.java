package com.example.srping_mc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;




@Table(name = "articleData")
@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private Long userId;
    private String articleTitle;
    @Lob
    @Column(columnDefinition="text")
    private String articleBody;
    private String articleDate;

    
}