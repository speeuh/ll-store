package com.ll.store.service.file;

import com.ll.store.repository.entity.file.File;
import org.springframework.web.multipart.MultipartFile;


public interface FileServiceInterface {
    File save(MultipartFile file, String productId);
}
