package com.ilicanspecialeducation.domain.data.request;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSavePost {
    private PostDTO post;
}
