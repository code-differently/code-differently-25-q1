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
        "column2", Boolean.class,
        "column3", Double.class,
        "column4", Float.class,
        "column5", Long.class,
        "column6", String.class,
        "column7", Short.class);
  }
}
