package com.ilicanspecialeducation.domain.facade.storage;

import com.ilicanspecialeducation.domain.domainmodel.storage.ImageStorageDomainModel;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;
import org.springframework.web.multipart.MultipartFile;

public record ImageStorageFacadeImpl(ImageStoragePort imageStoragePort) implements ImageStorageFacade {
    @Override
    public String uploadImage(MultipartFile file) {
        ImageStorageDomainModel domainModel = new ImageStorageDomainModel(imageStoragePort);
        return domainModel.uploadImage(file);
    }
}
