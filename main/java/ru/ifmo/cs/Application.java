package ru.ifmo.cs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import ru.ifmo.cs.config.DataConfig;
import ru.ifmo.cs.config.SecurityConfig;

/**
 * Created by Богдана on 12.11.2017.
 */

@Slf4j
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args){
       SpringApplication.run(Application.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(
                DataConfig.class, SecurityConfig.class
        );
    }
}
