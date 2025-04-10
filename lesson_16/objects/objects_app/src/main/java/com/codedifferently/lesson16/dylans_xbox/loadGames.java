

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class loadGames extends Xbox {
    private String filePath;

    public loadGames(String filePath) {
        this.filePath = filePath;
    }

    public void loadGamesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] gameDetails = line.split(",");
                int id = Integer.parseInt(gameDetails[0]);
                String name = gameDetails[4];
                addGame(id, name);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
}
