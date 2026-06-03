package com.ilicanspecialeducation.infrastructure.adapter.storage;

import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

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

    public String uploadImage(MultipartFile file) {
        // 1. Dosyanın orijinal uzantısını alıyoruz (.png, .jpg vb.)
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : ".jpg";

        // 2. Çakışma olmasın diye benzersiz bir dosya adı üretiyoruz
        String uniqueFileName = UUID.randomUUID().toString() + extension;

        try {
            // 3. Yükleme isteğini hazırlıyoruz
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(uniqueFileName)
                    .contentType(file.getContentType())
                    .build();

            // 4. Dosyayı byte dizisi olarak Supabase Storage'a pushluyoruz
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));

            // 5. Senin bulduğun yeni storage endpoint formatına uygun Public URL'i inşa ediyoruz
            // S3 URL'ini normal tarayıcıdan erişilebilecek public object linkine dönüştürür.
            String baseDomain = s3Endpoint.replace(".storage.supabase.co/storage/v1/s3", ".supabase.co/storage/v1/object/public/");
            return baseDomain + bucketName + "/" + uniqueFileName;

        } catch (IOException e) {
            throw new RuntimeException("Dosya Supabase'e yüklenirken hata oluştu: " + e.getMessage());
        }
    }
}
