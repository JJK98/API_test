package com.example.check.domain.article.dto;

import com.example.check.domain.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDTO {

    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String subject;
    private final String content;
    private final String author;

    public ArticleDTO(Article article){
        this.id = article.getId();
        this.createdDate = article.getCreatedDate();
        this.modifiedDate = article.getModifiedDate();
        this.subject = article.getSubject();
        this.content = article.getContent();
        this.author = article.getMember().getUsername();
    }
}
