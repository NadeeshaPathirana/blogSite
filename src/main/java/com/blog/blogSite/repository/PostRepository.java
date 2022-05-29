package com.blog.blogSite.repository;

import com.blog.blogSite.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending CrudRepository
public interface PostRepository extends CrudRepository<Post, Long>
{

}
