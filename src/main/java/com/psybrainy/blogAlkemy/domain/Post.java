package com.psybrainy.blogAlkemy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Post {

    private Long idPost;

    @NotEmpty(message = "EL POST DEBE TENER UN TITULO")
    private String title;

    @NotEmpty(message = "EL POST DEBE TENER UN CONTENIDO")
    private String content;

    private String category;

    private String image;

    private LocalDateTime date;
}
