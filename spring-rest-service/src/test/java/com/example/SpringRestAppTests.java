package com.example;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.Mongo;

import ma.example.SpringRestApp;

@SpringBootApplication
public class SpringRestAppTests {

    @Bean(destroyMethod="close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder()
                .version("2.6.4")
                .bindIp("127.0.0.1")
                .port(12345)
                .build();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringRestAppTests.class, args);
    }
}