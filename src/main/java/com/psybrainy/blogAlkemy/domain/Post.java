package com.psybrainy.blogAlkemy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Post {

    private Long idPost;

    private String title;

    private String content;

    private String category;

    private String image;

    private LocalDateTime date = LocalDateTime.now();
}
