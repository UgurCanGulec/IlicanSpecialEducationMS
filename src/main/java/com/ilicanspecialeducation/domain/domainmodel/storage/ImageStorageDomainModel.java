package com.ilicanspecialeducation.domain.domainmodel.storage;

import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;
import org.springframework.web.multipart.MultipartFile;

public record ImageStorageDomainModel(ImageStoragePort imageStoragePort) {

    public String uploadImage(MultipartFile file) {
        return imageStoragePort.uploadImage(file);
    }
}
