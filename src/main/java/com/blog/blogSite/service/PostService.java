package com.blog.blogSite.service;

import com.blog.blogSite.entity.Post;
import java.util.List;

public interface PostService
{
    // Save operation
    Post savePost(Post post);

    // Read operation
    List<Post> fetchPost();

    Post fetchPostById(Long postId);

    // Update operation
    Post updatePost(Post post, Long postId);

    // Delete operation
    void deletePostById(Long postId);
}
