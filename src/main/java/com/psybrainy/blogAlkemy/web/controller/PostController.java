package com.psybrainy.blogAlkemy.web.controller;

import com.psybrainy.blogAlkemy.domain.Category;
import com.psybrainy.blogAlkemy.domain.Post;
import com.psybrainy.blogAlkemy.domain.service.CategoryService;
import com.psybrainy.blogAlkemy.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAll(Model model){
        List<Post> postList = postService.getAll();

        model.addAttribute("posts", postList);

        return "/views/post/postList";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable("id") long idPost, Model model){
        Post post = postService.getPostById(idPost).orElseThrow();

        model.addAttribute("post", post);

        return "/views/post/postById";
    }

    @GetMapping("/createPost")
    public String create(Model model){
        Post post = new Post();

        List<Category> categoryList = categoryService.getAll();

        model.addAttribute("title", "Crear nuevo Post");
        model.addAttribute("post", post);
        model.addAttribute("categories", categoryList);

        return "/views/post/createPost";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post){

        post.setDate(LocalDateTime.now());

        postService.save(post);

        return "redirect:/post";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long postId){
        postService.deletePost(postId);

        return "redirect:/post";
    }
}
