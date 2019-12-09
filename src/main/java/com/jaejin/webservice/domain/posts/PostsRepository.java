package com.jaejin.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

// JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드 자동생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
    "FROM Posts p " +
    "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    @Query("SELECT p " +
    "FROM Posts p " +
    "WHERE p.id = ?1")
    Stream<Posts> findPostById(Long id);

    @Modifying
    @Query("UPDATE Posts p SET p.author = :author, p.content = :content, p.title = :title WHERE p.id = :id")
    void editPost(@Param("author") String author,
                  @Param("content") String content,
                  @Param("title") String title,
                  @Param("id") Long id);
}
