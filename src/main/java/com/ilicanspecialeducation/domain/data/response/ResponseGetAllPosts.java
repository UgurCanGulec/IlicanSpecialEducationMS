package com.ilicanspecialeducation.domain.data.response;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAllPosts {
    private List<PostDTO> posts;
}
