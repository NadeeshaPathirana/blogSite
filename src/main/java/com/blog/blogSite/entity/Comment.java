package com.blog.blogSite.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * this is the entity for Comment table
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Comment")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String body;

    @CreationTimestamp
    private Timestamp createdOn;

    @UpdateTimestamp
    private Timestamp modifiedOn;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
