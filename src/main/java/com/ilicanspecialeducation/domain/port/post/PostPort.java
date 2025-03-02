package com.ilicanspecialeducation.domain.port.post;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;

import java.util.List;

public interface PostPort {
    List<PostDTO> findAllPosts();

    void savePost(PostDTO post);

    void updatePost(PostDTO post);

    void deletePost(Long id);
}
