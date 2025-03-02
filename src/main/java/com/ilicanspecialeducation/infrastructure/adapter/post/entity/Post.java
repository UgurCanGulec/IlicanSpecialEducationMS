package com.ilicanspecialeducation.infrastructure.adapter.post.entity;

import com.ilicanspecialeducation.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE", length = 500, nullable = false)
    private String title;
    @Column(name = "CONTENT", length = 4000, nullable = false)
    private String content;
    @Column(name = "AUTHOR", length = 500, nullable = false)
    private String author;
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name = "PICTURE_URL", length = 4000)
    private String pictureUrl;
    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
