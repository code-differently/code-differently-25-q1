package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DavidAdenaikeProvider extends DataProvider {
  public String getProviderName() {
    return "davidadenaike";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", String.class,
        "column3", Float.class,
        "column4", Integer.class,
        "column5", Double.class,
        "column6", Boolean.class,
        "column7", Short.class);
  }
}
