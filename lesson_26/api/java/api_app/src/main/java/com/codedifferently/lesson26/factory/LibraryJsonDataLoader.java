package com.codedifferently.lesson26.factory;

import com.codedifferently.lesson26.models.LibraryDataModel;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/** Loads data from a JSON file and returns a LibraryDataModel object. */
@Service
public final class LibraryJsonDataLoader implements LibraryDataLoader {
  @Override
  public LibraryDataModel loadData() throws IOException {
    ObjectMapper objectMapper =
        JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            .build();

    // Load data from data.json file
    File file = new ClassPathResource("json/data.json").getFile();
    return objectMapper.readValue(file, LibraryDataModel.class);
  }
}
