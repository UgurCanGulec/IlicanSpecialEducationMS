package com.ilicanspecialeducation.domain.data.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class RequestSavePost {
    private PostDTO post;
    @JsonIgnore
    private MultipartFile file;
}
