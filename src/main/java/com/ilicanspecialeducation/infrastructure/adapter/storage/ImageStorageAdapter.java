package com.ilicanspecialeducation.infrastructure.adapter.storage;

import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageStorageAdapter implements ImageStoragePort {
    private final S3Client s3Client;

    @Value("${supabase.s3.bucket-name}")
    private String bucketName;

    @Value("${supabase.s3.endpoint}")
    private String s3Endpoint;

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

    @Override
    public String uploadImage(MultipartFile file) {
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("Yüklemek istediğiniz görsel çok büyük! Maksimum 5MB boyutunda dosya yükleyebilirsiniz.");
        }
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : ".jpg";
        String uniqueFileName = UUID.randomUUID().toString() + extension;
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(uniqueFileName)
                    .contentType(file.getContentType())
                    .build();
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
            String baseDomain = s3Endpoint.replace(".storage.supabase.co/storage/v1/s3", ".supabase.co/storage/v1/object/public/");
            return baseDomain + bucketName + "/" + uniqueFileName;
        } catch (S3Exception e) {
            String errorCode = e.awsErrorDetails().errorCode();
            if ("QuotaExceeded".equalsIgnoreCase(errorCode) || "StorageQuotaExceeded".equalsIgnoreCase(errorCode)) {
                throw new RuntimeException("Sistem depolama kapasitesi (Supabase kotası) dolmuştur! Lütfen sistem yöneticisiyle iletişime geçin.");
            }
            throw new RuntimeException("Depolama servisi hatası (" + errorCode + "): " + e.awsErrorDetails().errorMessage());
        } catch (IOException e) {
            throw new RuntimeException("Dosya okunurken bir hata oluştu: " + e.getMessage());
        }
    }
}