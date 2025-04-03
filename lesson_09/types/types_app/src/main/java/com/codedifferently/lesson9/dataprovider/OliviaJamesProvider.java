package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class OliviaJamesProvider extends DataProvider {

  public String getProviderName() {

    return "oliviajames";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", String.class,
        "column2", Double.class,
        "column3", Long.class,
        "column4", Short.class,
        "column5", Integer.class,
        "column6", Float.class,
        "column7", Boolean.class);
  }
}
