package br.com.mmcafe.teste.service;

import br.com.mmcafe.teste.model.Image;
import br.com.mmcafe.teste.producer.RabbitMQSender;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UploadService {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    public Boolean upload(MultipartFile file) throws IOException {

        if (file.isEmpty())
            throw new IllegalStateException("Cannot upload empty file");

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String url = amazonS3Service.upload(
                bucketName, file.getOriginalFilename(), Optional.of(metadata), file.getInputStream());

        Image image = Image.builder()
                .fileName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .url(url)
                .build();

        rabbitMQSender.send(exchange, image);

        return true;
    }
}
