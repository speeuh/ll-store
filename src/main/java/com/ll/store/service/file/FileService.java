package com.ll.store.service.file;

import com.ll.store.config.validation.exceptions.ProductNotFoundException;
import com.ll.store.repository.entity.file.File;
import com.ll.store.repository.entity.product.Product;
import com.ll.store.repository.file.FileRepository;
import com.ll.store.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService implements FileServiceInterface {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    ProductRepository productRepository;

    public File save(MultipartFile file, String productId) {
        try {
            return uploadFile(file, productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File uploadFile(MultipartFile file, String productId) throws IOException {
        byte[] data = file.getBytes();
        String fileName = file.getOriginalFilename();
        String type = file.getContentType();

        if(fileName.contains("..")) {
            throw new RuntimeException("Sorry! Filename contains invalid path sequence: " + fileName);
        }

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Not found product with id " + productId));

        File files = fileRepository.saveAndFlush(File.FileBuilder.newBuilder(data).
                withFileName(fileName).
                withType(type).
                withProduct(product).
                build());

        product.setFile(files);

        productRepository.saveAndFlush(product);

        return files;
    }

}
