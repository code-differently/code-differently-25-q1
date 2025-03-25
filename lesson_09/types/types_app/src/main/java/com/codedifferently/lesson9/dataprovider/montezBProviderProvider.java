package com.codedifferently.lesson9.dataprovider;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class montezBProviderProvider extends DataProvider {
  public String getProviderName() {
    return "montezBProvider";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", Float.class,
        "column3", Double.class,
        "column4", Short.class,
        "column5", Integer.class,
        "column6", String.class,
        "column7", Long.class);
  }
}


