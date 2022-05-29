package com.blog.blogSite.controller;

import com.blog.blogSite.entity.Author;
import com.blog.blogSite.mapper.AuthorMapper;
import com.blog.blogSite.mapper.MapperUtil;
import com.blog.blogSite.mapper.PostMapper;
import com.blog.blogSite.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Author controller - used to control requests related to authors
 */
@RestController
public class AuthorController
{

    @Autowired
    private AuthorService authorService;

    // Read operations
    @GetMapping("/authors")
    public List<AuthorMapper> fetchAuthorsList()
    {
        List<Author> authors = authorService.fetchAuthor();
        List<AuthorMapper> authorMappers = new ArrayList<>();
        for (Author author:authors)
        {
            authorMappers.add(MapperUtil.mapAuthor(author));
        }
        return authorMappers;
    }

    @GetMapping("/authors/{id}")
    public AuthorMapper fetchAuthorById(@PathVariable("id") Long authorId)
    {
        Author author = authorService.fetchAuthorsById(authorId);
        return MapperUtil.mapAuthor(author);
    }


    @GetMapping("/authors/{id}/posts")
    public List<PostMapper> fetchPostsByAuthorId(@PathVariable("id") Long authorId)
    {
        Author author = authorService.fetchAuthorsById(authorId);
        List<PostMapper> postMappers = MapperUtil.getPostsFromAuthor(author);
        return postMappers;
    }

    // Save operation
    @PostMapping("/authors")
    public AuthorMapper saveAuthor(@Valid @RequestBody Author author)
    {
        Author savedAuthor = authorService.saveAuthor(author);
        return MapperUtil.mapAuthor(savedAuthor);
    }

    // Update operation
    @PutMapping("/authors/{id}")
    public AuthorMapper updateAuthor(@RequestBody Author author, @PathVariable("id") Long authorId)
    {
        Author updatedAuthor = authorService.updateAuthor(author, authorId);
        return MapperUtil.mapAuthor(updatedAuthor);
    }

    // Delete operation
    @DeleteMapping("/authors/{id}")
    public String deleteAuthorById(@PathVariable("id") Long authorId)
    {
        authorService.deleteAuthorById(authorId);
        return "Deleted Successfully";
    }

}
