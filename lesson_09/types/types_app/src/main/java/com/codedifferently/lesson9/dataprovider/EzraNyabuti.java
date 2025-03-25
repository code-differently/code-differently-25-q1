package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EzraNyabuti extends DataProvider {
  public String getProviderName() {
    return "ezranyabuti";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Integer.class,
        "column2", Boolean.class,
        "column3", Short.class,
        "column4", Long.class,
        "column5", String.class,
        "column6", Double.class,
        "column7", Float.class);
  }
}
