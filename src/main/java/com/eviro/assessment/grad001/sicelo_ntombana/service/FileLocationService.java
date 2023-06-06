package com.eviro.assessment.grad001.sicelo_ntombana.service;

import com.eviro.assessment.grad001.sicelo_ntombana.config.Data;
import com.eviro.assessment.grad001.sicelo_ntombana.repository.FileSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileLocationService {
    @Autowired
    private FileSystemRepository fileSystemRepository;

    public FileSystemResource findImageInFileSystem(String name, String surname){
        //from resource dir get image
        return fileSystemRepository.getImageInFileSystem(name, surname);
    }

    public void save(File file, byte[] imageData){
        fileSystemRepository.save(file,imageData);
    }

}
