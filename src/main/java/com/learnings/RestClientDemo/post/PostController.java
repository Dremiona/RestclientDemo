package com.learnings.RestClientDemo.post;

import com.learnings.RestClientDemo.clients.JsonPlaceholderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

//    private final PostService postService; //without JsonPlaceholderService interface
    private final JsonPlaceholderService postService;

    public PostController(JsonPlaceholderService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(Integer id){
        postService.delete(id);
    }
}
