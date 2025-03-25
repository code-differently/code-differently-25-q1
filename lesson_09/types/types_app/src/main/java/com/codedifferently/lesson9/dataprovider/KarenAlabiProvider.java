package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KarenAlabiProvider extends DataProvider {
  public String getProviderName() {
    return "karenalabi";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Short.class,
        "column2", String.class,
        "column3", Boolean.class,
        "column4", Float.class,
        "column5", Long.class,
        "column6", Integer.class,
        "column7", Double.class);
  }
}
