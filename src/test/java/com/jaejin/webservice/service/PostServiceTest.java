package com.jaejin.webservice.service;

import com.jaejin.webservice.domain.posts.Posts;
import com.jaejin.webservice.domain.posts.PostsRepository;
import com.jaejin.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup () {
        postsRepository.deleteAll();
    }

    @Test
    public void save_DtoData_In_PostsTable () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jaejin@gmail.com")
                .content("test content")
                .title("test title")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void edit_DtoData () {
        //given
        PostsSaveRequestDto post_dto = PostsSaveRequestDto.builder()
                .author("jaejin@gmail.com")
                .content("test content")
                .title("test title")
                .build();

        postsService.save(post_dto);

        PostsSaveRequestDto put_dto = PostsSaveRequestDto.builder()
                .author("jaejin@gmail.com-update")
                .content("test content-update")
                .title("test title-update")
                .build();

        Posts posts = postsRepository.findAll().get(0);
        //when
        postsService.edit(put_dto, posts.getId());

        //then
        Posts posts_update = postsRepository.findAll().get(0);
        assertThat(posts_update.getAuthor()).isEqualTo("jaejin@gmail.com-update");
        assertThat(posts_update.getContent()).isEqualTo("test content-update");
        assertThat(posts_update.getTitle()).isEqualTo("test title-update");
    }

    @Test
    public void delete_DtoData() {
        //given
        PostsSaveRequestDto post_dto = PostsSaveRequestDto.builder()
                .author("jaejin@gmail.com")
                .content("test content")
                .title("test title")
                .build();

        postsService.save(post_dto);

        Posts posts = postsRepository.findAll().get(0);
        postsService.delete(posts.getId());

        if (postsRepository.count() != 0) {
            Posts posts_delete = postsRepository.findAll().get(0);
            assertThat(posts_delete.getAuthor()).isNotEqualTo(posts.getAuthor());
            assertThat(posts_delete.getTitle()).isNotEqualTo(posts.getTitle());
            assertThat(posts_delete.getContent()).isNotEqualTo(posts.getContent());
        }
    }
}
