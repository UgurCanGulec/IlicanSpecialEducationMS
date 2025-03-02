package com.ilicanspecialeducation.infrastructure.mapper;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import com.ilicanspecialeducation.infrastructure.adapter.post.entity.Post;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PostMapper {

    PostDTO mapEntity2DTO(Post entity);

    Post mapDTO2Entity(PostDTO dto);

    List<PostDTO> mapEntityList2DTOList(List<Post> entityList);

    List<Post> mapDTOList2EntityList(List<PostDTO> dtoList);

}
