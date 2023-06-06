package com.eviro.assessment.grad001.sicelo_ntombana.service;

import com.eviro.assessment.grad001.sicelo_ntombana.model.AccountProfile;
import com.eviro.assessment.grad001.sicelo_ntombana.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.sicelo_ntombana.repository.FileSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AccountProfileService {
    @Autowired
    private AccountProfileRepository accountProfileRepository;
    //@Autowired
    //private FileSystemRepository fileSystemRepository;

    public List<AccountProfile> getAll(){
        return accountProfileRepository.findAll();
    }

    //public FileSystemResource getImageInFileSystem(String location, String name, String surname){
    //    //from resource dir get image
    //    return fileSystemRepository.getImageInFileSystem(name, surname);
    //}



}
