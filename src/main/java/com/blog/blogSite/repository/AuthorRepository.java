package com.blog.blogSite.repository;

import com.blog.blogSite.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository
public interface AuthorRepository   extends CrudRepository<Author, Long>
{

}
