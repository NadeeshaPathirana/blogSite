package com.blog.blogSite.controller;

import com.blog.blogSite.entity.Post;
import com.blog.blogSite.util.MapperUtil;
import com.blog.blogSite.mapper.PostMapper;
import com.blog.blogSite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * PostController - used to control requests related to posts
 */
@RestController
public class PostController
{

    @Autowired
    private PostService postService;

    // Read operations
    @GetMapping("/posts")
    public ResponseEntity fetchPostList()
    {
        return ResponseEntity.ok(MapperUtil.getPostsMapper(postService.fetchPost()));
    }

    @GetMapping("/posts/{id}")
    public PostMapper fetchPostById(@PathVariable("id") Long postId)
    {
        return MapperUtil.mapPost(postService.fetchPostById(postId));
    }

    @GetMapping("/posts/{id}/comments")
    public ResponseEntity fetchCommentsByPostId(@PathVariable("id") Long postId)
    {
        Post post = postService.fetchPostById(postId);
        return ResponseEntity.ok(MapperUtil.getCommentByPost(post));
    }

    // Save operation
    @PostMapping("/posts")
    public ResponseEntity savePost(@Valid @RequestBody Post post)
    {
        return ResponseEntity.ok(MapperUtil.mapPost(postService.savePost(post)));
    }

    // Update operation
    @PutMapping("/posts/{id}")
    public ResponseEntity updatePost(@RequestBody Post post, @PathVariable("id") Long postId)
    {
        return ResponseEntity.ok(MapperUtil.mapPost(postService.updatePost(post, postId)));
    }

    // Delete operation
    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable("id") Long postId)
    {
        postService.deletePostById(postId);
        return "Deleted Successfully";
    }

}
