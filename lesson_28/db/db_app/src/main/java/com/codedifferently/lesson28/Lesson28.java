package com.codedifferently.lesson28;

import com.codedifferently.lesson28.cli.LibraryApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson28 implements CommandLineRunner {
  @Autowired private LibraryApp libraryApp;

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson28.class);
    application.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    // Don't run as an app if we're running as a JUnit test.
    if (isJUnitTest()) {
      return;
    }

    libraryApp.run(args);
  }

  private static boolean isJUnitTest() {
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      if (element.getClassName().startsWith("org.junit.")) {
        return true;
      }
    }
    return false;
  }
}
