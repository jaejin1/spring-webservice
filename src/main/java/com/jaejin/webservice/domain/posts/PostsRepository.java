package com.jaejin.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

// JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드 자동생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
    "FROM Posts p " +
    "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
