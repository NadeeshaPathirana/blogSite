package com.blog.blogSite.controller;

import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.mapper.CommentMapper;
import com.blog.blogSite.mapper.MapperUtil;
import com.blog.blogSite.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Comment Controller - used to control requests related to comments
 */
@RestController
public class CommentController
{

    @Autowired
    private CommentService commentService;

    // Read operations
    @GetMapping("/comments")
    public List<CommentMapper> fetchCommentList()
    {
        List<Comment> comments = commentService.fetchComment();
        return MapperUtil.getCommentMappers(comments);
    }

    @GetMapping("/comments/{id}")
    public CommentMapper fetchCommentById(@PathVariable("id") Long commentId)
    {
        return MapperUtil.mapComment(commentService.fetchCommentById(commentId));
    }

    // Save operation
    @PostMapping("/comments")
    public CommentMapper savePost(@Valid @RequestBody Comment comment)
    {
        return MapperUtil.mapComment(commentService.saveComment(comment));
    }

    // Update operation
    @PutMapping("/comments/{id}")
    public CommentMapper updateComment(@RequestBody Comment comment, @PathVariable("id") Long commentId)
    {
        return MapperUtil.mapComment(commentService.updateComment(comment, commentId));
    }

    // Delete operation
    @DeleteMapping("/comments/{id}")
    public String deletePostById(@PathVariable("id") Long commentId)
    {
        commentService.deleteCommentById(commentId);
        return "Deleted Successfully";
    }

}
