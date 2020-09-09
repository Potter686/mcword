package com.example.srping_mc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.srping_mc.entity.Article;
import com.example.srping_mc.repository.ArticleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    
    @PostMapping("/save")
    public String articleSave(@RequestBody Article article){
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        article.setArticleDate(dateFormat.format(dateNow));

        //暂时设定作者
        article.setArticleId(123L);
        Article article1 = articleRepository.save(article);
        boolean result = StringUtils.isEmpty(article1);
        if (!result){
            return "success";
        }
        else return "error";
    }

    @GetMapping("findAll/{page}/{size}")
    public Page<Article> findAll(@PathVariable("page") Integer page , @PathVariable("size") Integer size ){
//       分页
        Pageable pageable = PageRequest.of(page-1,size);
        return articleRepository.findAll(pageable);
    }
    @GetMapping("findById/{id}")
    public Article findArticleById(@PathVariable("id") Long id ){
        return articleRepository.findById(id).get();
    }
    
}
