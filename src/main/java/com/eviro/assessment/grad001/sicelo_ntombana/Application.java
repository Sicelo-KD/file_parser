package com.eviro.assessment.grad001.sicelo_ntombana;
import com.eviro.assessment.grad001.sicelo_ntombana.CSVParser;
import com.eviro.assessment.grad001.sicelo_ntombana.config.Data;
import com.eviro.assessment.grad001.sicelo_ntombana.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Data.class, DataConfig.class})
public class Application {

    public static void main(String[] args) {
        //SpringApplication application = new SpringApplication(DomainLayerApplication.class);
        SpringApplication.run(Application.class, args);
        CSVParser parser = new CSVParser();
        parser.parseCSV(new File("resources/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv"));
    }
}
