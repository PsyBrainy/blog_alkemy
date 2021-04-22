package com.psybrainy.blogAlkemy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Post {

    private String idPost;

    private String title;

    private String content;

    private String category;

    private String image;

    private LocalDateTime date = LocalDateTime.now();
}
