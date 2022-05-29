package com.blog.blogSite.service;

import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.exception.ResourceAlreadyExists;
import com.blog.blogSite.exception.ResourceNotFoundException;
import com.blog.blogSite.repository.CommentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Comment service implementation
 */
// Annotation
@Service
public class CommentServiceImpl  implements CommentService
{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment)
    {
        Optional<Comment> byId = commentRepository.findById(comment.getId());
        if (byId.isPresent())
        {
            throw new ResourceAlreadyExists();
        }
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> fetchComment()
    {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment fetchCommentById(Long commentId) {
        Optional<Comment> byId = commentRepository.findById(commentId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        return commentRepository.findById(commentId).get();
    }

    @Override
    public Comment updateComment(Comment comment, Long commentId)
    {
        Optional<Comment> byId = commentRepository.findById(commentId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        Comment commentDB = commentRepository.findById(commentId).get();

        if (Objects.nonNull(comment.getPost().getId())) {
            commentDB.getPost().setId(comment.getPost().getId());
        }

        if (Objects.nonNull(comment.getName()) && !"".equalsIgnoreCase(comment.getName())) {
            commentDB.setName(comment.getName());
        }

        if (Objects.nonNull(comment.getEmail()) && !"".equalsIgnoreCase(comment.getEmail())) {
            commentDB.setEmail(comment.getEmail());
        }

        if (Objects.nonNull(comment.getBody()) && !"".equalsIgnoreCase(comment.getBody())) {
            commentDB.setBody(comment.getBody());
        }

        if (Objects.nonNull(comment.getCreatedOn())) {
            commentDB.setCreatedOn(comment.getCreatedOn());
        }

        if (Objects.nonNull(comment.getModifiedOn())) {
            commentDB.setModifiedOn(comment.getModifiedOn());
        }

        return commentRepository.save(commentDB);
    }

    @Override
    public void deleteCommentById(Long commentId)
    {
        Optional<Comment> byId = commentRepository.findById(commentId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        commentRepository.deleteById(commentId);
    }
}
