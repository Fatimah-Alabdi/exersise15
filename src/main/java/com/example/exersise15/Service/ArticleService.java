package com.example.exersise15.Service;

import com.example.exersise15.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    ArrayList<Article> articles = new ArrayList<>();

    public ArrayList<Article> getArticles() {
        return articles;

    }
    public void addArticle(Article article) {
        articles.add(article);

    }
public boolean deleteArticle(int id){
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).getId()==id){
                articles.remove(i);
                return true;
            }
        }
        return false;
}
public boolean updatreArticle(int id,Article article){
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).getId()==id){
                articles.set(i,article);
                return true;
            }
        }
        return false;
}
public boolean publishArticle(int id){
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).getId()==id){
               articles.get(i).setPublished(true);
               return true;
            }
        }
        return false;
}
public ArrayList<Article> getPublishArticle(){
        ArrayList<Article> spublishArticles = new ArrayList<>();
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).isPublished()==true){
                spublishArticles.add(articles.get(i));
            }
        }
        if(spublishArticles.isEmpty()){
            return null;
        }
        return spublishArticles;



}
public ArrayList<Article> getArticleByCategory(String category) {
        ArrayList<Article> carticles = new ArrayList<>();
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).getCategory().equals(category)){
                carticles.add(articles.get(i));



            }

        }
        if(carticles.isEmpty()){
            return null;
        }
    return carticles;


}

}
