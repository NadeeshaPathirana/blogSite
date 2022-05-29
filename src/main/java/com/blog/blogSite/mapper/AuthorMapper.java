package com.blog.blogSite.mapper;

import lombok.Data;

/**
 * A lightweight object of the Author entity. This will be used to map the response for an API request
 */
@Data
public class AuthorMapper
{
    private Long id;
    private String name;
    private String userName;
    private String email;
    private String address;
}
