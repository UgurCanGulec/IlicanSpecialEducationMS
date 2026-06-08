package com.ilicanspecialeducation.domain.domainmodel.post;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import com.ilicanspecialeducation.domain.port.post.PostPort;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;

import java.util.List;

public record PostDomainModel(PostPort postPort, ImageStoragePort imageStoragePort) {

    public List<PostDTO> findAllPosts() {
        return postPort.findAllPosts();
    }

    public void savePost(PostDTO post) {
        postPort.savePost(post);
    }

    public void updatePost(PostDTO post) {
        postPort.updatePost(post);
    }

    public void deletePost(Long id) {
        PostDTO post = postPort.getPostById(id);
        imageStoragePort.deleteImage(post.getPictureUrl());
        postPort.deletePost(id);
    }
}
