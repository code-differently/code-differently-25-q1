package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DavisDProvider extends DataProvider {
  public String getProviderName() {
    return "davis.d";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", String.class,
        "column3", Integer.class,
        "column4", Boolean.class,
        "column5", Double.class,
        "column6", Short.class,
        "column7", Long.class);
  }
}
