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
        "column1", Boolean.class,
        "column2", Integer.class,
        "column3", Short.class,
        "column4", Double.class,
        "column5", Float.class,
        "column6", Long.class,
        "column7", String.class);
  }
}
