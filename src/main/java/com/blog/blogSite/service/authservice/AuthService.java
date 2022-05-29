package com.blog.blogSite.service.authservice;


public interface AuthService {

    Boolean validateBasicAuthentication(String userName, String password, String basicAuthHeaderValue);

}
