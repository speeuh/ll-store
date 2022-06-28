package com.ll.store.controller.file;

import com.ll.store.repository.entity.file.File;
import com.ll.store.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/{productId}")
    public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile file,
                                             @PathVariable(name = "productId") String productId) {

        File files = fileService.save(file, productId);
       return ResponseEntity.status(HttpStatus.CREATED).body(files);
    }
}
