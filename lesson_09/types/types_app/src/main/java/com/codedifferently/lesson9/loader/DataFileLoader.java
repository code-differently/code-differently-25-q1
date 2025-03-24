package com.codedifferently.lesson9.loader;

import com.codedifferently.lesson9.dataprovider.DataProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public final class DataFileLoader {

  private final DataProvider dataProvider;

  public DataFileLoader(DataProvider dataProvider) {
    this.dataProvider = dataProvider;
  }

  public List<Map<String, String>> readData() throws IOException {
    var filename =
        File.separator
            + String.join(File.separator, "data", dataProvider.getProviderName() + ".json");
    var gson = new Gson();
    try (var reader = new InputStreamReader(this.getClass().getResourceAsStream(filename))) {
      var typeToken = new TypeToken<List<Map<String, String>>>() {}.getType();
      return gson.fromJson(reader, typeToken);
    } catch (IOException e) {
      throw new IOException("Error reading data from " + filename, e);
    }
  }
}
