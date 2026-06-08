package com.ilicanspecialeducation.domain.facade.storage;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageFacade {

    String uploadImage(MultipartFile file);
}
