package com.codedifferently.lesson9.dataprovider;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class NiaPProvider extends DataProvider {
  public String getProviderName() {
    return "niap";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", Integer.class,
        "column3", Float.class,
        "column4", Short.class,
        "column5", Long.class,
        "column6", Double.class,
        "column7", String.class);
  }
}

