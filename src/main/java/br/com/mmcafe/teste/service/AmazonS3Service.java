package br.com.mmcafe.teste.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class AmazonS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    public String upload(
            String path,
            String fileName,
            Optional<Map<String, String>> optionalMetaData,
            InputStream inputStream) {
        ObjectMetadata objectMetadata = new ObjectMetadata();

        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(objectMetadata::addUserMetadata);
            }
        });
        amazonS3.putObject(path, fileName, inputStream, objectMetadata);
        URL s3Url = amazonS3.getUrl(path, fileName);

        return s3Url.toExternalForm();
    }
}
