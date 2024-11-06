package com.example.check.domain.article.entity;

import com.example.check.domain.member.entity.Member;
import com.example.check.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String subject;
    private String content;

    @ManyToOne
    private Member member;
}
