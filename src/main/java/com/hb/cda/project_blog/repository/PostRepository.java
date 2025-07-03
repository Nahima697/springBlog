package com.hb.cda.project_blog.repository;

import com.hb.cda.project_blog.entity.Post;
import com.hb.cda.project_blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    Page<Post> findByAuthor(User author, Pageable pageable);
}
