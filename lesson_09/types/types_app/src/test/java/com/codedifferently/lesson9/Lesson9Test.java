package com.codedifferently.lesson9;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson9.dataprovider.DataProvider;
import com.codedifferently.lesson9.loader.DataFileLoader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Lesson9.class)
@ExtendWith(SoftAssertionsExtension.class)
class Lesson9Test {
  @Autowired private List<DataProvider> dataProviders;

  @Test
  void testDataProvider_filesLoad() throws IOException {
    assertThat(dataProviders.size()).isGreaterThanOrEqualTo(1);
    for (DataProvider provider : dataProviders) {
      // Arrange
      var loader = new DataFileLoader(provider);

      // Act
      List<Map<String, String>> data = loader.readData();

      // Assert
      assertThat(data).as("File should return data.").isNotNull();
      assertThat(data.size()).as("File should have 10 rows.").isEqualTo(10);
    }
  }

  @Test
  void testDataProvider_namesAreUnique() {
    Set<String> providerNames =
        dataProviders.stream().map(p -> p.getProviderName()).collect(Collectors.toSet());

    assertThat(providerNames.size())
        .as("Data provider names must be unique.")
        .isEqualTo(dataProviders.size());
  }

  @Test
  void testDataProvider_configuredCorrectly() throws IOException {
    for (DataProvider provider : dataProviders) {
      System.out.println("Checking provider " + provider.getProviderName());

      // Arrange
      var loader = new DataFileLoader(provider);
      List<Map<String, String>> data = loader.readData();

      // Act
      Map<String, Class> columnTypeByName = provider.getColumnTypeByName();

      // Assert
      assertThat(columnTypeByName.size())
          .as("Number of column types must match number of columns in file.")
          .isEqualTo(data.get(0).size());
      Set<String> uniqueColumnTypes =
          columnTypeByName.entrySet().stream()
              .map(c -> c.getValue().getName())
              .collect(Collectors.toSet());
      assertThat(uniqueColumnTypes.size())
          .as("Each column should be a different type.")
          .isEqualTo(columnTypeByName.size());
    }
  }

  @Test
  void testDataProvider_correctlyParsesData() throws Exception {
    for (DataProvider provider : dataProviders) {
      // Arrange
      var loader = new DataFileLoader(provider);
      List<Map<String, String>> data = loader.readData();

      // Act
      List<Map<String, Object>> parsedData = provider.parseData(data);

      // Assert
      for (var i = 0; i < data.size(); ++i) {
        Map<String, String> row = data.get(0);
        Map<String, Object> parsed = parsedData.get(0);
        for (String key : row.keySet()) {
          assertThat(parsed.get(key).toString()).isEqualTo(row.get(key));
        }
      }
    }
  }
}
