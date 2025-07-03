package com.hb.cda.project_blog.repository;

import com.hb.cda.project_blog.entity.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends CrudRepository<Reaction, String> {
}
