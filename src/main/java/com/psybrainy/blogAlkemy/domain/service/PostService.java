package com.psybrainy.blogAlkemy.domain.service;

import com.psybrainy.blogAlkemy.domain.Post;
import com.psybrainy.blogAlkemy.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> getAll(){
        return repo.getAll();
    }

    public Optional<Post> getPostById(long idPost){
        return repo.getPostById(idPost);
    }

    public void save(Post post){
        if (post.getImage()== null){
            post.setImage("");
        }
        repo.savePost(post);
    }

    public boolean deletePost(Long postId){
        return getPostById(postId)
                .map(post -> {
                    repo.delete(postId);
                    return true;
                }).orElse(false);
    }
}
