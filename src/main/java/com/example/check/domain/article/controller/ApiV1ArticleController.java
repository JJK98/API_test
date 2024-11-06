package com.example.check.domain.article.controller;

import com.example.check.domain.article.dto.ArticleDTO;
import com.example.check.domain.article.dto.reponse.ArticleResponse;
import com.example.check.domain.article.dto.reponse.ArticlesResponse;
import com.example.check.domain.article.entity.Article;
import com.example.check.domain.article.service.ArticleService;
import com.example.check.domain.member.entity.Member;
import com.example.check.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public RsData<ArticlesResponse> list(){
//        List<ArticleDTO> articleList =this.articleService.getList();
        List<ArticleDTO> articleList = new ArrayList<>();
        Member member1 = new Member("작성자","1234" );

        Article article1 = new Article("첫 번째 게시글", "내용입니다.", member1);
        articleList.add(new ArticleDTO(article1));
        Article article2 = new Article("두 번째 게시글", "내용2입니다.", member1);
        articleList.add(new ArticleDTO(article2));
        Article article3 = new Article("세 번째 게시글", "내용3입니다.", member1);
        articleList.add(new ArticleDTO(article3));

        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id")Long id){
        Member member1 = new Member("작성자","1234" );

        Article article1 = new Article("첫 번째 게시글", "내용입니다.", member1);
        return RsData.of("200", "게시글 단건 조회 성공",new ArticleResponse(new ArticleDTO(article1)));
    }
}
