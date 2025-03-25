package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EvanPhilakhongProvider extends DataProvider {
  public String getProviderName() {
    return "evanphilakhong";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", String.class,
        "column3", Long.class,
        "column4", Double.class,
        "column5", Integer.class,
        "column6", Boolean.class,
        "column7", Short.class);
  }
}
