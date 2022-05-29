package com.blog.blogSite.controller;

import com.blog.blogSite.entity.Post;
import com.blog.blogSite.mapper.CommentMapper;
import com.blog.blogSite.mapper.MapperUtil;
import com.blog.blogSite.mapper.PostMapper;
import com.blog.blogSite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<PostMapper> fetchPostList()
    {
        return MapperUtil.getPostsMapper(postService.fetchPost());
    }

    @GetMapping("/posts/{id}")
    public PostMapper fetchPostById(@PathVariable("id") Long postId)
    {
        return MapperUtil.mapPost(postService.fetchPostById(postId));
    }

    @GetMapping("/posts/{id}/comments")
    public List<CommentMapper> fetchCommentsByPostId(@PathVariable("id") Long postId)
    {
        Post post = postService.fetchPostById(postId);
        return MapperUtil.getCommentByPost(post);
    }

    // Save operation
    @PostMapping("/posts")
    public PostMapper savePost(@Valid @RequestBody Post post)
    {
        return MapperUtil.mapPost(postService.savePost(post));
    }

    // Update operation
    @PutMapping("/posts/{id}")
    public PostMapper updatePost(@RequestBody Post post, @PathVariable("id") Long postId)
    {
        return MapperUtil.mapPost(postService.updatePost(post, postId));
    }

    // Delete operation
    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable("id") Long postId)
    {
        postService.deletePostById(postId);
        return "Deleted Successfully";
    }

}
