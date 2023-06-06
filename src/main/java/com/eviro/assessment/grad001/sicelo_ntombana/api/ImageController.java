package com.eviro.assessment.grad001.sicelo_ntombana.api;

import com.eviro.assessment.grad001.sicelo_ntombana.model.AccountProfile;
import com.eviro.assessment.grad001.sicelo_ntombana.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.sicelo_ntombana.repository.FileSystemRepository;
import com.eviro.assessment.grad001.sicelo_ntombana.service.AccountProfileService;
import com.eviro.assessment.grad001.sicelo_ntombana.service.FileLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    //FileSystemRepository fileSystemRepository;
    FileLocationService fileLocationService;
    AccountProfileService accountProfileService;

    @GetMapping("/")
    public List<AccountProfile> getNameSurname(){
        return accountProfileService.getAll();
    }

    @GetMapping(value = "/{name}/{surname}/{link}")
    public FileSystemResource gethttpImageLink(@PathVariable String name,@PathVariable String surname){
        return fileLocationService.findImageInFileSystem(name,surname);
    }
}