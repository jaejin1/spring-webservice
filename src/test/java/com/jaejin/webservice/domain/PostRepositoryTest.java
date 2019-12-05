package com.jaejin.webservice.domain;

import com.jaejin.webservice.domain.posts.Posts;
import com.jaejin.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        // 테스트 메소드가 끝날때마다 repository 비우기
        postsRepository.deleteAll();
    }

    @Test
    public void Load_PostSave() {
        //given
        postsRepository.save(Posts.builder()
        .title("test post title")
        .content("test content")
        .author("jaejin@gmail.com")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test post title"));
        assertThat(posts.getContent(), is("test content"));
    }

    @Test
    public void BaseTimeEntity_regist () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
        .title("test post")
        .content("test contentetet")
        .author("jaejin2@naver.com")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
