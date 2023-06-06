package com.eviro.assessment.grad001.sicelo_ntombana.repository;

import com.eviro.assessment.grad001.sicelo_ntombana.config.Data;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

@Repository
public class FileSystemRepository {

    @Autowired
    Data data;

    String RESOURCES_DIR = Objects.requireNonNull(
            FileSystemRepository.class.getResource("/") )
            .getPath() + data.getDir();

    public FileSystemResource getImageInFileSystem( String name, String surname){
        //from resource dir get image
        return new FileSystemResource(RESOURCES_DIR+"_"+name+"_"+surname);
    }

    public void save(File file, byte[] imageData){
        try {
            FileUtils.writeByteArrayToFile(file,imageData);
        }catch (IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
