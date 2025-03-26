package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AnanatawaProvider extends DataProvider {
  public String getProviderName() {
    return "awatanana";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class,
        "column2", String.class,
        "column3", Integer.class,
        "column4", Short.class,
        "column5", Boolean.class,
        "column6", Float.class,
        "column7", Long.class);
  }
}
