package com.codedifferently.lesson9.dataprovider;

import java.util.Map;

public class KhaylaSaundersProvider extends DataProvider {
  public String getProviderName() {
    return "khaylasaunders";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", Integer.class,
        "column3", Double.class,
        "column4", String.class,
        "column5", Short.class,
        "column6", Long.class,
        "column7", Float.class);
  }
}
