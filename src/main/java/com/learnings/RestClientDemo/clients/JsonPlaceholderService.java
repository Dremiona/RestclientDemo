package com.learnings.RestClientDemo.clients;

import com.learnings.RestClientDemo.post.Post;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> findAll();

    @GetExchange("/posts/{}id")
    Post findById(Integer id);

    @PostExchange("/posts")
    Post create(Post post);

    @DeleteExchange("/posts/{id}")
    void delete(Integer id);
}
