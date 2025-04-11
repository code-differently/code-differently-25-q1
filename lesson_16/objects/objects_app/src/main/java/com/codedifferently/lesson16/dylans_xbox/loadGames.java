package com.codedifferently.lesson16.dylans_xbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadGames {
  private String filePath;

  public LoadGames(String filePath) {
    this.filePath = filePath;
  }

  public void loadGamesFromFile(Xbox xbox) throws Exception {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      br.readLine(); // Skip the header line
      while ((line = br.readLine()) != null) {
        String[] gameDetails = line.split(",");
        int id = Integer.parseInt(gameDetails[0].trim());
        String name = gameDetails[1].trim();

        xbox.inputGame(id, name);
      }
    } catch (IOException e) {
      throw new Exception("Error reading the games file: " + e.getMessage());
    }
  }
}
