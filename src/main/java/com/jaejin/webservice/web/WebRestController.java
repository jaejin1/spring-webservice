package com.jaejin.webservice.web;

import com.jaejin.webservice.domain.posts.Posts;
import com.jaejin.webservice.dto.posts.PostsSaveRequestDto;
import com.jaejin.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Posts> getPost(@PathVariable Long id) {
        return postsService.getPost(id);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Posts>> getPosts() {
        return postsService.getPosts();
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsService.save(dto);
    }

    @PutMapping("/posts/{id}")
    public void editPosts(@RequestBody PostsSaveRequestDto dto, @PathVariable Long id) {
        postsService.edit(dto, id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePosts(@PathVariable Long id) {
        postsService.delete(id);
    }
}
