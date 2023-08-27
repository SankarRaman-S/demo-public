package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class FileOperationController {

    public File convert(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();
        File convFile = new File(fileName);

        boolean fileCreated = convFile.createNewFile();


        if (!fileCreated){
            throw new IOException("Test");
        }

        try (FileOutputStream fos = new FileOutputStream(convFile)){
            fos.write(file.getBytes());
        }catch (FileNotFoundException e){
            log.error("Exception", e.getMessage());
        }

        return convFile;

    }

}
