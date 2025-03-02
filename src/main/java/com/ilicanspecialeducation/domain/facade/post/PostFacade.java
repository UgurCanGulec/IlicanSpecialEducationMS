package com.ilicanspecialeducation.domain.facade.post;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;

import java.util.List;

public interface PostFacade {
    List<PostDTO> findAllPosts();

    void savePost(PostDTO post);

    void updatePost(PostDTO post);

    void deletePost(Long id);
}
