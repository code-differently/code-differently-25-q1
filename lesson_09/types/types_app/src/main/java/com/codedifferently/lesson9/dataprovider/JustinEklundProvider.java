package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JustinEklundProvider extends DataProvider {
  public String getProviderName() {
    return "justineklund";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Integer.class,
        "column2", Boolean.class,
        "column3", Long.class,
        "column4", Short.class,
        "column5", Float.class,
        "column6", String.class,
        "column7", Double.class);
  }
}
