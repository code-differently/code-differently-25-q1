package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MercedesMathewsProvider extends DataProvider {
  public String getProviderName() {
    return "mercedesmathews";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", String.class,
        "column2", Long.class,
        "column3", Integer.class,
        "column4", Float.class,
        "column5", Boolean.class,
        "column6", Double.class,
        "column7", Short.class);
  }
}
