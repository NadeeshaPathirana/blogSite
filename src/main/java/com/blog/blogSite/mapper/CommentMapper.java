package com.blog.blogSite.mapper;

import lombok.Data;
import java.sql.Timestamp;

/**
 * A lightweight object of the Comment entity. This will be used to map the response for an API request
 */
@Data
public class CommentMapper
{
    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
