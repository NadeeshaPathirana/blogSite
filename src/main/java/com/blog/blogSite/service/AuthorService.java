package com.blog.blogSite.service;

import com.blog.blogSite.entity.Author;

import java.util.List;

public interface AuthorService
{
    // Save operation
    Author saveAuthor(Author author);

    // Read operation
    List<Author> fetchAuthor();

    // Update operation
    Author updateAuthor(Author author, Long authorId);

    // Delete operation
    void deleteAuthorById(Long authorId);

    Author fetchAuthorsById(Long authorId);
}
