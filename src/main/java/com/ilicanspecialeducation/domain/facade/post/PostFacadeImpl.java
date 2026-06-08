package com.ilicanspecialeducation.domain.facade.post;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import com.ilicanspecialeducation.domain.domainmodel.post.PostDomainModel;
import com.ilicanspecialeducation.domain.port.post.PostPort;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;

import java.util.List;

public record PostFacadeImpl(PostPort postPort, ImageStoragePort imageStoragePort) implements PostFacade {
    @Override
    public List<PostDTO> findAllPosts() {
        PostDomainModel postDomainModel = new PostDomainModel(postPort, imageStoragePort);
        return postDomainModel.findAllPosts();
    }

    @Override
    public void savePost(PostDTO post) {
        PostDomainModel postDomainModel = new PostDomainModel(postPort, imageStoragePort);
        postDomainModel.savePost(post);
    }

    @Override
    public void updatePost(PostDTO post) {
        PostDomainModel postDomainModel = new PostDomainModel(postPort, imageStoragePort);
        postDomainModel.updatePost(post);
    }

    @Override
    public void deletePost(Long id) {
        PostDomainModel postDomainModel = new PostDomainModel(postPort, imageStoragePort);
        postDomainModel.deletePost(id);
    }
}
