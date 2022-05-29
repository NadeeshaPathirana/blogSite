package com.blog.blogSite.service;

import com.blog.blogSite.entity.Author;
import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.exception.ResourceAlreadyExists;
import com.blog.blogSite.exception.ResourceNotFoundException;
import com.blog.blogSite.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Author> byId = authorRepository.findById(author.getId());
        if (byId.isPresent())
        {
            throw new ResourceAlreadyExists();
        }
        return authorRepository.save(author);
    }

    @Override
    public List<Author> fetchAuthor() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author fetchAuthorsById(Long authorId) {
        Optional<Author> byId = authorRepository.findById(authorId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        return  authorRepository.findById(authorId).get();
    }

    @Override
    public Author updateAuthor(Author author, Long authorId) {
        Optional<Author> byId = authorRepository.findById(authorId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
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
        Optional<Author> byId = authorRepository.findById(authorId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        authorRepository.deleteById(authorId);
    }

}
