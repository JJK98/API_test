package com.example.check.domain.article.dto.reponse;

import com.example.check.domain.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesResponse {
private final List<ArticleDTO> articleList;
}
