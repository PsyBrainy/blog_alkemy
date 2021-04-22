package com.psybrainy.blogAlkemy.web.controller;

import com.psybrainy.blogAlkemy.domain.Post;
import com.psybrainy.blogAlkemy.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping({"/home", "/index","/"})
    public String home(Model model){

        List<Post> postList = postService.getAll();

        model.addAttribute("posts", postList);

        return "/views/home";
    }
}
