package com.blog.blogSite.service;

import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.entity.Post;
import com.blog.blogSite.exception.ResourceAlreadyExists;
import com.blog.blogSite.exception.ResourceNotFoundException;
import com.blog.blogSite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Post service implementation
 */
// Annotation
@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        Optional<Post> byId = postRepository.findById(post.getId());
        if (byId.isPresent())
        {
            throw new ResourceAlreadyExists();
        }
        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPost() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post fetchPostById(Long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        return postRepository.findById(postId).get();
    }

    @Override
    public Post updatePost(Post post, Long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        Post postDB = postRepository.findById(postId).get();

        if (Objects.nonNull(post.getTitle()) && !"".equalsIgnoreCase(post.getTitle())) {
            postDB.setTitle(post.getTitle());
        }

        if (Objects.nonNull(post.getBody()) && !"".equalsIgnoreCase(post.getBody())) {
            postDB.setBody(post.getBody());
        }

        if (Objects.nonNull(post.getAuthor().getId())) {
            postDB.getAuthor().setId(post.getAuthor().getId());
        }

        if (Objects.nonNull(post.getCreatedOn())) {
            postDB.setCreatedOn(post.getCreatedOn());
        }

        if (Objects.nonNull(post.getModifiedOn())) {
            postDB.setModifiedOn(post.getModifiedOn());
        }

        return postRepository.save(postDB);
    }

    @Override
    public void deletePostById(Long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        if (byId.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        postRepository.deleteById(postId);
    }
}
