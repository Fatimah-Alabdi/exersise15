package com.example.exersise15.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import java.util.Date;

@Data
@AllArgsConstructor
public class Article {
    @NotNull(message="id cannot be null")
    private int id;

    @NotEmpty(message = "title cannot be empty")
    @Size(min = 10,max = 100 ,message = "title must be within the range 10-100")
    private String title;

    @NotEmpty(message = "author cannot be empty")
    @Size(min = 5,max = 20 ,message = "auther must be within the range 10-100")
    private String author;

    @NotEmpty(message = "content cannot be empty")
    @Size(min = 201,message = "content must more than 200 character")

    private String content;

    @NotEmpty(message = "category cannot be empty")
    @Pattern(regexp = "politics|sports |technology", message = "Category must be either 'politics' or 'sports' or 'technology' only")

    private String category;
    @NotEmpty(message = "imageUrl cannot be empty")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;

    private Date publishDate;

}
