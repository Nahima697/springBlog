package com.hb.cda.project_blog.repository;

import com.hb.cda.project_blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User>findByUsername(String username);
}
