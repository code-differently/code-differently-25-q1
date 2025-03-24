package com.codedifferently.lesson9.dataprovider;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is a base class for data providers. It provides a method for parsing data from a list
 * of maps.
 */
public abstract class DataProvider {
  /** Returns the name of the provider. */
  public abstract String getProviderName();

  /** Gets a map of column types keyed by column name. */
  public abstract Map<String, Class> getColumnTypeByName();

  /**
   * Given a list of data objects, returns the list with values converted to the appropriate type.
   *
   * @param data A list of data objects containing values keyed by column name.
   * @return A new list with object values converted to the appropriate type.
   */
  public List<Map<String, Object>> parseData(List<Map<String, String>> data) throws Exception {
    Map<String, Class> columnTypeByName = getColumnTypeByName();
    return data.stream().map(row -> parseRow(columnTypeByName, row)).collect(Collectors.toList());
  }

  /**
   * Parses a single row of data using the provided column types mapping.
   *
   * @param columnTypeByName A map containing the type of a column keyed by its name.
   * @param row A bag of values keyed by column name.
   * @return A new list of data values converted to the appropriate type.
   */
  private Map<String, Object> parseRow(
      Map<String, Class> columnTypeByName, Map<String, String> row) {
    var parsedRow = new java.util.HashMap<String, Object>();
    row.forEach(
        (key, value) -> {
          Class type = columnTypeByName.get(key);
          try {
            parsedRow.put(key, type.getConstructor(String.class).newInstance(value));
          } catch (Exception e) {
            throw new RuntimeException(
                "Error parsing data for " + key + " as type " + type.getName());
          }
        });
    return parsedRow;
  }
}
