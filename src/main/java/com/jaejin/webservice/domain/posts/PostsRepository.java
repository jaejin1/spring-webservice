package com.jaejin.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

// JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드 자동생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
    "FROM Posts p " +
    "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    @Query("SELECT p " +
    "FROM Posts p " +
    "WHERE p.id = :id")
    Stream<Posts> findPostById(@Param("id") Long id);

    @Query("SELECT p " +
            "FROM Posts p " +
            "WHERE p.id = :id")
    Posts getPost(@Param("id") Long id);

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    List<Posts> getPosts();

    @Modifying
    @Query("UPDATE Posts p SET p.author = :author, p.content = :content, p.title = :title, p.modifiedDate = :modifiedDate WHERE p.id = :id")
    void editPost(@Param("author") String author,
                  @Param("content") String content,
                  @Param("title") String title,
                  @Param("modifiedDate") LocalDateTime modifiedDate,
                  @Param("id") Long id);
}
