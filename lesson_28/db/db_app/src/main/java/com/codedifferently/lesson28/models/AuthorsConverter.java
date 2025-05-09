package com.codedifferently.lesson28.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class AuthorsConverter implements AttributeConverter<List<String>, String> {
  @Override
  public String convertToDatabaseColumn(List<String> authors) {
    return String.join(", ", authors);
  }

  @Override
  public List<String> convertToEntityAttribute(String authors) {
    return authors != null ? List.of(authors.split(", ")) : List.of();
  }
}
