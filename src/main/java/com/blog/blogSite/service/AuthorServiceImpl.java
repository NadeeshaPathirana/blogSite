package com.blog.blogSite.service;

import com.blog.blogSite.entity.Author;
import com.blog.blogSite.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Author service implementation
 */
// Annotation
@Service
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> fetchAuthor() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author fetchAuthorsById(Long authorId) {
        return  authorRepository.findById(authorId).get();
    }

    @Override
    public Author updateAuthor(Author author, Long authorId) {
        Author authorDB = authorRepository.findById(authorId).get();

        if (Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())) {
            authorDB.setName(author.getName());
        }

        if (Objects.nonNull(author.getUserName()) && !"".equalsIgnoreCase(author.getUserName())) {
            authorDB.setUserName(author.getUserName());
        }

        if (Objects.nonNull(author.getEmail()) && !"".equalsIgnoreCase(author.getEmail())) {
            authorDB.setEmail(author.getEmail());
        }

        if (Objects.nonNull(author.getAddress()) && !"".equalsIgnoreCase(author.getAddress())) {
            authorDB.setAddress(author.getAddress());
        }

        return authorRepository.save(authorDB);
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }

}
