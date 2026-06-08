package com.ilicanspecialeducation.infrastructure.controller;

import com.ilicanspecialeducation.domain.data.dto.PostDTO;
import com.ilicanspecialeducation.domain.data.request.RequestSavePost;
import com.ilicanspecialeducation.domain.data.response.BaseResponse;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAllPosts;
import com.ilicanspecialeducation.domain.facade.post.PostFacade;
import com.ilicanspecialeducation.domain.facade.post.PostFacadeImpl;
import com.ilicanspecialeducation.domain.facade.storage.ImageStorageFacade;
import com.ilicanspecialeducation.domain.facade.storage.ImageStorageFacadeImpl;
import com.ilicanspecialeducation.domain.port.post.PostPort;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostFacade postFacade;
    private final ImageStorageFacade imageStorageFacade;

    @Autowired
    public PostController(PostPort postPort, ImageStoragePort imageStoragePort) {
        this.postFacade = new PostFacadeImpl(postPort);
        this.imageStorageFacade = new ImageStorageFacadeImpl(imageStoragePort);
    }

    @GetMapping(value = "/all")
    @Operation(description = "Retrieves all posts")
    public ResponseEntity<BaseResponse<ResponseGetAllPosts>> getAllPosts() {
        List<PostDTO> posts = postFacade.findAllPosts();
        return ResponseEntity.ok(new BaseResponse<>(new ResponseGetAllPosts(posts)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(description = "Add a new post")
    public ResponseEntity<BaseResponse<Boolean>> saveNewPosts(@ModelAttribute @Valid RequestSavePost request) {
        if (Objects.nonNull(request.getFile()) && !request.getFile().isEmpty()) {
            String uploadedImageUrl = imageStorageFacade.uploadImage(request.getFile());
            request.getPost().setPictureUrl(uploadedImageUrl);
        }
        postFacade.savePost(request.getPost());
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(description = "Update existing post")
    public ResponseEntity<BaseResponse<Boolean>> updatePost(@ModelAttribute @Valid RequestSavePost request) {
        if (Objects.nonNull(request.getFile()) && !request.getFile().isEmpty()) {
            String uploadedImageUrl = imageStorageFacade.uploadImage(request.getFile());
            request.getPost().setPictureUrl(uploadedImageUrl);
        }
        postFacade.updatePost(request.getPost());
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(description = "Delete a post")
    public ResponseEntity<BaseResponse<Boolean>> removePost(@PathVariable("id") Long id) {
        postFacade.deletePost(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }
}
