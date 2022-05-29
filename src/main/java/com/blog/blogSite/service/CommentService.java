package com.blog.blogSite.service;

import com.blog.blogSite.entity.Comment;

import java.util.List;

public interface CommentService
{
    // Save operation
    Comment saveComment(Comment comment);

    // Read operation
    List<Comment> fetchComment();

    Comment fetchCommentById(Long commentId);

    // Update operation
    Comment updateComment(Comment comment, Long commentId);

    // Delete operation
    void deleteCommentById(Long commentId);
}
