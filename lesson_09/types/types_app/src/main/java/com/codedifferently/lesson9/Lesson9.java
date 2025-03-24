package com.codedifferently.lesson9;

import com.codedifferently.lesson9.generator.SampleFileGenerator;
import java.io.File;
import java.nio.file.Paths;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson9 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson9.class);
    application.run(args);
  }

  public void run(String... args) throws Exception {
    if (args.length == 0) {
      return;
    }

    var providerName = args[0];
    if (providerName == null) {
      throw new IllegalArgumentException("Provider name is required");
    }

    String path = getDataPath();
    var fileGenerator = new SampleFileGenerator();
    fileGenerator.createTestFile(path, providerName);
  }

  private static String getDataPath() {
    String[] pathParts = {
      Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", "data"
    };
    return String.join(File.separator, pathParts);
  }
}
