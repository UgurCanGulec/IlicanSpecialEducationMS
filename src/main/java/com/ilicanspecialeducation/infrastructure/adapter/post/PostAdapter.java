package com.ilicanspecialeducation.infrastructure.adapter.post;

import com.ilicanspecialeducation.domain.exceptions.PostNotFoundException;
import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import com.ilicanspecialeducation.infrastructure.adapter.post.entity.Post;
import com.ilicanspecialeducation.domain.enums.Status;
import com.ilicanspecialeducation.infrastructure.adapter.post.repository.PostRepository;
import com.ilicanspecialeducation.domain.port.post.PostPort;
import com.ilicanspecialeducation.infrastructure.mapper.PostMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.ilicanspecialeducation.domain.exceptions.ExceptionMessage.POST_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class PostAdapter implements PostPort {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDTO> findAllPosts() {
        List<Post> entityList = Optional.of(postRepository.findAll())
                .filter(list -> !CollectionUtils.isEmpty(list))
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND));
        return postMapper.mapEntityList2DTOList(entityList);
    }

    @Override
    public void savePost(PostDTO post) {
        Post entity = postMapper.mapDTO2Entity(post);
        entity.setCreateDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVE);
        postRepository.save(entity);
    }

    @Override
    public void updatePost(PostDTO post) {
        Post entity = postRepository.findById(post.getId())
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND));
        entity.setStatus(post.getStatus());
        entity.setAuthor(post.getAuthor());
        entity.setContent(post.getContent());
        entity.setTitle(post.getTitle());
        entity.setCreateDate(LocalDateTime.now());
        entity.setPictureUrl(post.getPictureUrl());
        postRepository.save(entity);
    }

    @Override
    public void deletePost(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND));
        postRepository.delete(entity);
    }
}
