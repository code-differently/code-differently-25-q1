package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DylanLafferty extends DataProvider {
  public String getProviderName() {
    return "dylanlafferty";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Integer.class,
        "column2", Short.class,
        "column3", String.class,
        "column4", Float.class,
        "column5", Long.class,
        "column6", Double.class,
        "column7", Boolean.class);
  }
}
