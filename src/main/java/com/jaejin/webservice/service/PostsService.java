package com.jaejin.webservice.service;

import com.jaejin.webservice.domain.posts.PostsRepository;
import com.jaejin.webservice.dto.posts.PostsMainResponseDto;
import com.jaejin.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}