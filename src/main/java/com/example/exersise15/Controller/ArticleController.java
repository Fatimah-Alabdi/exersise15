package com.example.exersise15.Controller;

import com.example.exersise15.Api.ApiRespons;
import com.example.exersise15.Model.Article;
import com.example.exersise15.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/get")
    public ResponseEntity getArticle(){
        ArrayList<Article> articles = articleService.getArticles();
        return ResponseEntity.status(200).body(articles);
    }
    @PostMapping("/add")
    public ResponseEntity addArticle(@Valid@RequestBody Article article, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        articleService.addArticle(article);
        return ResponseEntity.status(201).body(new ApiRespons("Article add Successful"));



    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteArticle(@PathVariable int id){
        boolean isdeleted= articleService.deleteArticle(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiRespons("Article Delete Successful"));
        }
        return ResponseEntity.status(404).body(new ApiRespons("Article Not Found"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateArticle(@PathVariable int id,@Valid @RequestBody Article article, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isubdate= articleService.updatreArticle(id,article);
        if(isubdate){
            return ResponseEntity.status(200).body(new ApiRespons("Article Update Successful"));
        }
        return ResponseEntity.status(404).body(new ApiRespons("Article Not Found"));

    }
    @PutMapping("/publish/{id}")
    public ResponseEntity publishnewArticle(@PathVariable int id){
        boolean ispublish= articleService.publishArticle(id);
        if(ispublish){
            return ResponseEntity.status(200).body(new ApiRespons("Article Publish Successful"));
        }
        return ResponseEntity.status(404).body(new ApiRespons("Article Not Found"));

    }
    @GetMapping("/getpublish")
    public ResponseEntity getpublish(){
        ArrayList<Article> articles = articleService.getPublishArticle();
        if(articles==null){
            return ResponseEntity.status(404).body(new ApiRespons("Article Not Found"));
        }
        return ResponseEntity.status(200).body(articles);
    }
    @GetMapping("/getbycatecory/{category}")
    public ResponseEntity getbycategory(@PathVariable String category){
        ArrayList<Article> articles = articleService.getArticleByCategory(category);
        if(articles==null){
            return ResponseEntity.status(404).body(new ApiRespons("Article Not Found"));
        }
        return ResponseEntity.status(200).body(articles);
    }

}
