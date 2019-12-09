package com.jaejin.webservice.web;

import com.jaejin.webservice.dto.posts.PostsSaveRequestDto;
import com.jaejin.webservice.dto.puts.PutsSaveRequestDto;
import com.jaejin.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsService.save(dto);
    }

    @PutMapping("/posts/{id}")
    public void editPosts(@RequestBody PutsSaveRequestDto dto, @PathVariable Long id) { postsService.edit(dto, id); }

    @DeleteMapping("/posts/{id}")
    public void deletePosts(@PathVariable Long id) { postsService.delete(id); }
}
