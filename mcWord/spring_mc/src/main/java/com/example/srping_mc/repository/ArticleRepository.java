package com.example.srping_mc.repository;

import com.example.srping_mc.entity.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article , Long>{
    
    
}   