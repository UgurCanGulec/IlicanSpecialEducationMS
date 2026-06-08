package com.ilicanspecialeducation.domain.port.storage;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStoragePort {

    String uploadImage(MultipartFile file);

    void deleteImage(String pictureUrl);
}
