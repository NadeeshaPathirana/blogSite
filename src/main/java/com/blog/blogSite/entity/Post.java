package com.blog.blogSite.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * this is the entity for Post table
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Post")
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String body;

    @CreationTimestamp
    private Timestamp createdOn;

    @UpdateTimestamp
    private Timestamp modifiedOn;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //todo: to string, getters, setters, serialization,
}
