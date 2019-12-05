package com.jaejin.webservice.web;

import com.jaejin.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        // handlebars-spring-boot-starter 덕분에 반환할때 앞의 파일 확장자는 자동으로 지정.
        // 여기서는 src/main/resources/templates/main.hbs로 전환
        return "main";
    }
}
