package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MontezBrProvider extends DataProvider {
  public String getProviderName() {
    return "montezb";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", Short.class,
        "column3", Boolean.class,
        "column4", Integer.class,
        "column5", Long.class,
        "column6", Double.class,
        "column7", String.class);
  }
}
