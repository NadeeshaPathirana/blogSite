package com.blog.blogSite.util;

import com.blog.blogSite.entity.Author;
import com.blog.blogSite.entity.Comment;
import com.blog.blogSite.entity.Post;
import com.blog.blogSite.mapper.AuthorMapper;
import com.blog.blogSite.mapper.CommentMapper;
import com.blog.blogSite.mapper.PostMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * used to map the entities to lightweight objects
 */
public class MapperUtil
{
    /**
     * map the given entity to lightweight object
     * @param author
     * @return
     */
    public static AuthorMapper mapAuthor(Author author)
    {
        AuthorMapper authorMapper = new AuthorMapper();
        if (author != null)
        {
            authorMapper.setId(author.getId());
            authorMapper.setAddress(author.getAddress());
            authorMapper.setEmail(author.getEmail());
            authorMapper.setName(author.getName());
            authorMapper.setUserName(author.getUserName());
        }
        return authorMapper;
    }

    /**
     * map the given entity to lightweight object
     * @param comment
     * @return
     */
    public static CommentMapper mapComment(Comment comment)
    {
        CommentMapper commentMapper = new CommentMapper();
        if (comment != null)
        {
            commentMapper.setId(comment.getId());
            commentMapper.setBody(comment.getBody());
            commentMapper.setEmail(comment.getEmail());
            commentMapper.setName(comment.getName());
            commentMapper.setPostId(comment.getPost() != null ? comment.getPost().getId() : -1);
            commentMapper.setCreatedOn(comment.getCreatedOn());
            commentMapper.setModifiedOn(comment.getModifiedOn());
        }
        return commentMapper;
    }

    /**
     * map the given entity to lightweight object
     * @param post
     * @return
     */
    public static PostMapper mapPost(Post post)
    {
        PostMapper postMapper = new PostMapper();
        if (post != null)
        {
            postMapper.setId(post.getId());
            postMapper.setTitle(post.getTitle());
            postMapper.setBody(post.getBody());
            postMapper.setAuthorId(post.getAuthor() != null ? post.getAuthor().getId() : -1);
            postMapper.setCreatedOn(post.getCreatedOn());
            postMapper.setModifiedOn(post.getModifiedOn());
        }
        return postMapper;
    }

    /**
     * map entity list to a lightweight object list
     * @param author
     * @return
     */
    public static List<PostMapper> getPostsFromAuthor(Author author)
    {
        List<PostMapper> postMappers = new ArrayList<>();
        if (author != null && author.getPosts() != null)
        {
            for (Post post : author.getPosts())
            {
                postMappers.add(mapPost(post));
            }
        }
        return postMappers;
    }

    /**
     * return a list of lightweight objects for an entity
     * @param comments
     * @return
     */
    public static List<CommentMapper> getCommentMappers(List<Comment> comments)
    {
        List<CommentMapper> commentMappers = new ArrayList<>();
        if (comments != null)
        {
            for (Comment comment : comments)
            {
                commentMappers.add(mapComment(comment));
            }
        }
        return commentMappers;
    }

    /**
     * return a list of lightweight objects for an entity
     * @param posts
     * @return
     */
    public static List<PostMapper> getPostsMapper(List<Post> posts)
    {
        List<PostMapper> postMappers = new ArrayList<>();
        if (posts != null)
        {
            for (Post post : posts)
            {
                postMappers.add(mapPost(post));
            }
        }
        return postMappers;
    }

    /**
     * return the comment list for a given post
     * @param post
     * @return
     */
    public static List<CommentMapper> getCommentByPost(Post post)
    {
        List<CommentMapper> commentMappers = new ArrayList<>();
        if (post != null && post.getComments() != null)
        {
            for (Comment comment : post.getComments())
            {
                commentMappers.add(mapComment(comment));
            }
        }
        return commentMappers;
    }
}
