package com.example.check.domain.article.controller;

import com.example.check.domain.article.dto.ArticleDTO;
import com.example.check.domain.article.dto.reponse.ArticleCreateResponse;
import com.example.check.domain.article.dto.reponse.ArticleResponse;
import com.example.check.domain.article.dto.reponse.ArticlesResponse;
import com.example.check.domain.article.dto.request.ArticleCreateRequest;
import com.example.check.domain.article.entity.Article;
import com.example.check.domain.article.service.ArticleService;
import com.example.check.domain.member.entity.Member;
import com.example.check.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        List<ArticleDTO> articleList =this.articleService.getList();



        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id")Long id){
        Member member1 = new Member("작성자","1234" );

        Article article1 = this.articleService.getArticle(id);
        if(article1.getId().equals(null)){
            return RsData.of("404","게시글이 존재하지 않습니다.");
        }
        return RsData.of("200", "게시글 단건 조회 성공",new ArticleResponse(new ArticleDTO(article1)));
    }

    @PostMapping("")
    public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest){

        Article article =this.articleService.write(articleCreateRequest.getSubject(), articleCreateRequest.getContent());
        return RsData.of("201", "등록성공", new ArticleCreateResponse(article));
    }
}
