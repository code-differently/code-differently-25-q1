package com.codedifferently.lesson16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson16 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson16.class);
    application.run(args);
  }
}
