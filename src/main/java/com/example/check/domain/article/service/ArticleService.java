package com.example.check.domain.article.service;

import com.example.check.domain.article.dto.ArticleDTO;
import com.example.check.domain.article.entity.Article;
import com.example.check.domain.article.repository.ArticleRepository;
import com.example.check.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDTO> getList(){
        List<Article> articleList = this.articleRepository.findAll();
        Member member1 = new Member("작성자","1234" );

        articleList.forEach(article -> {
            if (article.getMember() == null) {
                article.setMember(member1);
            }
        });

        List<ArticleDTO> articleDTOList = articleList.stream()
                .map(article -> new ArticleDTO(article))
                .collect(Collectors.toList());

        return articleDTOList;
    }
    public Article getArticle(Long id){
        Member member1 = new Member("작성자","1234" );
        Optional<Article> article = this.articleRepository.findById(id);
        Article article1 = article.get();
        if(article.isEmpty()){
            return new Article();
        }
        article1.setMember(member1);
        return article1;
    }



    public Article write(String subject, String content){
        Member member1 = new Member("작성자","1234" );
        Article article =Article.builder()
                .subject(subject)
                .content(content)
                .member(member1)
                .build();
        this.articleRepository.save(article);

        return article;
    }

}
