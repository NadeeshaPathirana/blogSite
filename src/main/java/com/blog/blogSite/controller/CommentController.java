package com.blog.blogSite.controller;

import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.util.MapperUtil;
import com.blog.blogSite.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity fetchCommentList()
    {
        List<Comment> comments = commentService.fetchComment();
        return ResponseEntity.ok(MapperUtil.getCommentMappers(comments));
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity fetchCommentById(@PathVariable("id") Long commentId)
    {
        return ResponseEntity.ok(MapperUtil.mapComment(commentService.fetchCommentById(commentId)));
    }

    // Save operation
    @PostMapping("/comments")
    public ResponseEntity savePost(@Valid @RequestBody Comment comment)
    {
        return ResponseEntity.ok(MapperUtil.mapComment(commentService.saveComment(comment)));
    }

    // Update operation
    @PutMapping("/comments/{id}")
    public ResponseEntity updateComment(@RequestBody Comment comment, @PathVariable("id") Long commentId)
    {
        return ResponseEntity.ok(MapperUtil.mapComment(commentService.updateComment(comment, commentId)));
    }

    // Delete operation
    @DeleteMapping("/comments/{id}")
    public String deletePostById(@PathVariable("id") Long commentId)
    {
        commentService.deleteCommentById(commentId);
        return "Deleted Successfully";
    }

}
