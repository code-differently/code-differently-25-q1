package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JbeyProvider extends DataProvider {
  public String getProviderName() {
    return "JBey";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Short.class,
        "column2", Integer.class,
        "column3", Float.class,
        "column4", Double.class,
        "column5", Long.class,
        "column6", Boolean.class,
        "column7", String.class);
  }
}
