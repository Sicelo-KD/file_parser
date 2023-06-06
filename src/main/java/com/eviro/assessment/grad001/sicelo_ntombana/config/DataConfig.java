package com.eviro.assessment.grad001.sicelo_ntombana.config;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class DataConfig {

    @Autowired private Environment env;

    @Bean(name="datasource")
    public Data dataSource() {

        Data data = new Data();
        //data.set(env.getProperty("jdbc.url"));
        data.setDir(env.getProperty("data.file"));
        data.setFile(env.getProperty("data.dir"));
        return data;
    }

}
