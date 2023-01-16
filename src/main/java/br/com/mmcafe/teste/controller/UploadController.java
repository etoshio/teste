package br.com.mmcafe.teste.controller;

import br.com.mmcafe.teste.service.UploadService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Api(value = "UploadController", tags = { "Upload Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Upload Controller", description = "Upload File S3") })
@CrossOrigin(origins = "*")
public class UploadController {
    @Autowired
    UploadService uploadService;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criado com sucesso."),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @ApiOperation(value = "Upload do arquivo")
    @PostMapping("upload")
    public ResponseEntity upload(
            @RequestParam("file") MultipartFile file) throws IOException {
        if(uploadService.upload(file)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
