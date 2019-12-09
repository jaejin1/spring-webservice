package com.jaejin.webservice.service;

import com.jaejin.webservice.domain.posts.Posts;
import com.jaejin.webservice.domain.posts.PostsRepository;
import com.jaejin.webservice.dto.posts.PostsDetailResponseDto;
import com.jaejin.webservice.dto.posts.PostsMainResponseDto;
import com.jaejin.webservice.dto.posts.PostsSaveRequestDto;
import com.jaejin.webservice.dto.puts.PutsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // 모소드 내에서 Exception이 발생하면 해당 메소드에서 이뤄진 모든 DB작업 초기화
    @Transactional // DB 데이터 등록/수정/삭제 하는 service 메소드는 필수임.
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void edit(PutsSaveRequestDto dto, Long id) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        postsRepository.editPost(
                dto.toEntity().getAuthor(),
                dto.toEntity().getContent(),
                dto.toEntity().getTitle(),
                currentDateTime,
                id);
    }

    @Transactional
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsDetailResponseDto> findPostById(Long id) {
        return postsRepository.findPostById(id)
                .map(PostsDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Posts> getPost(Long id) {
        return new ResponseEntity<>(postsRepository.getPost(id), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Posts>> getPosts() {
        return new ResponseEntity<>(postsRepository.getPosts(), HttpStatus.OK);
    }
}
