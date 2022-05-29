package com.blog.blogSite.mapper;

import lombok.Data;

import java.sql.Timestamp;

/**
 * A lightweight object of the Post entity. This will be used to map the response for an API request
 */
@Data
public class PostMapper
{
    private Long id;
    private Long authorId;
    private String title;
    private String body;
    private Timestamp createdOn;
    private Timestamp modifiedOn;

}
