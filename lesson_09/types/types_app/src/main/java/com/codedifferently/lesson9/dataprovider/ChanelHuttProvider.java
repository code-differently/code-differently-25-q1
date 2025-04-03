package com.codedifferently.lesson9.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ChanelHuttProvider extends DataProvider {
  public String getProviderName() {
    return "chanelhutt";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class,
        "column2", Short.class,
        "column3", Integer.class,
        "column4", String.class,
        "column5", Long.class,
        "column6", Boolean.class,
        "column7", Float.class);
  }
}
