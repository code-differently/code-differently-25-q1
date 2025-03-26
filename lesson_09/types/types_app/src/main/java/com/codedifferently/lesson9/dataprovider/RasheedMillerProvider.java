package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RasheedMillerProvider extends DataProvider {
  public String getProviderName() {
    return "RMill";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", Short.class,
        "column3", Float.class,
        "column4", String.class,
        "column5", Integer.class,
        "column6", Double.class,
        "column7", Boolean.class);
  }
}
