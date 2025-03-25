package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MeikoStephensProvider extends DataProvider {
  public String getProviderName() {
    return "meikostephens";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", Float.class,
        "column3", Double.class,
        "column4", Short.class,
        "column5", String.class,
        "column6", Boolean.class,
        "column7", Integer.class);
  }
}
