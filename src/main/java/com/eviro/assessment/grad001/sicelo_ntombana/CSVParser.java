package com.eviro.assessment.grad001.sicelo_ntombana;

import com.eviro.assessment.grad001.sicelo_ntombana.model.AccountProfile;
import com.eviro.assessment.grad001.sicelo_ntombana.service.FileLocationService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.*;
import java.net.URI;
import java.util.Base64;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


import static java.util.Objects.requireNonNull;

public class CSVParser implements FileParser{

    int NAME_COLUMN = 0;
    int SURNAME_COLUMN = 1;
    int IMAGE_FORMAT = 2;
    int IMAGE_DATA = 3;
    String EXPECTED_HEADER =  "name,surname,imageFormat,imageData".strip();

    AtomicInteger counter = new AtomicInteger();

    String systemPath ="/home/sicelo/myWork/personal_projects/spring-starter/file-parser";
    String contentPath = "/src/main/resources/images/";


    String fileName = "picture" + counter.addAndGet(1);

    String absolutePath = this.systemPath + this.contentPath + fileName;

    @Autowired
    FileLocationService svc;

    @Override
    public void parseCSV(File csvFile) {
        requireNonNull( csvFile );
        if( csvFile.exists() && csvFile.canRead() ){
            try {
                LineNumberReader lineReader = new LineNumberReader(new FileReader(csvFile));
                //Check Header
                if (lineReader.readLine().equals(EXPECTED_HEADER)){
                    //readFile(lineReader);

                    lineReader.lines().forEach(line -> {
                        String[] details =  line.split(",");
                        File imageFile = convertCSVDataToImage( details[IMAGE_DATA]);
                        URI imageLink = createImageLink(imageFile);

                        String name = details[NAME_COLUMN];
                        String surname = details[SURNAME_COLUMN];
                        String format = details[IMAGE_FORMAT];

                        System.out.println("Code Ran Successfully");
                    });

                }

            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException.getMessage());

            }catch (IOException ioException){
                System.out.println(ioException.getMessage());
                System.out.println("UnExpected Error");
            }
        }else{
            throw new RuntimeException("Cannot Read file Or File Does Not Exist");
        }
    }

    @Override
    public File convertCSVDataToImage(String Base64ImageData) {
        byte[] decodedBytes = Base64.getDecoder().decode(Base64ImageData);
        File pic = new File(absolutePath);
        svc.save(pic, decodedBytes);
        return pic;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return fileImage.toURI();
    }

    public void readFile(LineNumberReader reader){

        reader.lines().forEach(line -> {
            String[] details =  line.split(",");
            String name = details[NAME_COLUMN];
            String surname = details[SURNAME_COLUMN];
            String format = details[IMAGE_FORMAT];

            File imageFile = convertCSVDataToImage( details[IMAGE_DATA]);
            URI imageLink = createImageLink(imageFile);
            System.out.println("Code Ran Successfully");
        });

    }


    Set<AccountProfile> parseDataLines(final LineNumberReader in, String link ){
        final Set<AccountProfile> profiles = in.lines()
                .map( this::splitLineIntoValues )
                .map( this::asAccountProfile )
                .collect( Collectors.toSet() );
        return profiles;
    }

    private String[] splitLineIntoValues(String aCsvLine){
        return aCsvLine.split(",");
    }

    private AccountProfile asAccountProfile(String[] details){
        return new AccountProfile(details[NAME_COLUMN], details[SURNAME_COLUMN] );
    }

}
