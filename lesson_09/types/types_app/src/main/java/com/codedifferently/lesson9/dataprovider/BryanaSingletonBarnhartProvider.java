package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BryanaSingletonBarnhartProvider extends DataProvider {
  public String getProviderName() {
    return "bryanasingletonbarnhart";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", Short.class,
        "column3", Double.class,
        "column4", String.class,
        "column5", Long.class,
        "column6", Integer.class,
        "column7", Boolean.class);
  }
}
