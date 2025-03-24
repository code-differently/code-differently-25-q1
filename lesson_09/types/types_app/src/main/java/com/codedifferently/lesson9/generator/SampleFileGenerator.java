package com.codedifferently.lesson9.generator;

import com.codedifferently.lesson9.generator.Generators.*;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** A class to generate a sample file with random data. */
public class SampleFileGenerator {

  private static final ValueGenerator[] GENERATORS = {
    new IntValueGenerator(),
    new StringValueGenerator(),
    new DoubleValueGenerator(),
    new ShortValueGenerator(),
    new LongValueGenerator(),
    new FloatValueGenerator(),
    new BooleanValueGenerator()
  };

  /**
   * Create a test file with sample data.
   *
   * @param path the path to the directory where the file will be created
   * @param providerName the name of the provider
   */
  public void createTestFile(String path, String providerName) {
    var generators = getShuffledGenerators();
    ArrayList<Map<String, String>> rows = createSampleData(generators);
    saveToJsonFile(path, providerName, rows);
  }

  private List<ValueGenerator> getShuffledGenerators() {
    var generators = Arrays.asList(GENERATORS);
    Collections.shuffle(generators);
    return generators;
  }

  private ArrayList<Map<String, String>> createSampleData(List<ValueGenerator> generators) {
    var rows = new ArrayList<Map<String, String>>();
    for (var i = 0; i < 10; ++i) {
      Map<String, String> row = createRow(generators);
      rows.add(createRow(generators));
    }
    return rows;
  }

  private Map<String, String> createRow(List<ValueGenerator> generators) {
    var row = new LinkedHashMap<String, String>();
    for (int i = 0; i < GENERATORS.length; ++i) {
      var columnIndex = i + 1;
      row.put("column" + columnIndex, GENERATORS[i].generateValue());
    }
    return row;
  }

  private void saveToJsonFile(
      String path, String providerName, ArrayList<Map<String, String>> rows) {
    var file = new File(path + File.separator + providerName + ".json");
    file.getParentFile().mkdirs();
    var gson = new GsonBuilder().setPrettyPrinting().create();
    try (var writer = new FileWriter(file, false)) {
      writer.write(gson.toJson(rows));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
