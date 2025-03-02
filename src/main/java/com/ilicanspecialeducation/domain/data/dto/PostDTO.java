package com.ilicanspecialeducation.domain.data.dto;

import com.ilicanspecialeducation.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDate createDate;
    private String pictureUrl;
    private Status status;
}
