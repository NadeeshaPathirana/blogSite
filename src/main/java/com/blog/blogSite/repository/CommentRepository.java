package com.blog.blogSite.repository;

import com.blog.blogSite.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>
{

}
