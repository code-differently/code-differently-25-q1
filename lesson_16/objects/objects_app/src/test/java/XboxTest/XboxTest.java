package com.codedifferently.lesson16.dylans_xbox;

import java.beans.Transient;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import main.dylans_xbox.java.loadGames;

public class XboxTest {
	@Test 
    public void testaddGame() throws GameException {
        Xbox xbox = new Xbox("Series X", 600, "Black", false);
        loadGames loader = new loadGames("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
        loader.loadGamesFromFile(xbox);

        HashMap<Integer, String> games = xbox.getGames();
        assertTrue(games.containsKey(10));
        assertEguals("Baldur's Gate 3", games.get(10));
    }
    
    @Test
    public void testXboxModelEnumValues() {
        Xbox.XboxModel[] models = Xbox.XboxModel.values();
        assertEquals(6, models.length);
        assertEquals(Xbox.XboxModel.XBOXONE, models[0]);
        assertEquals(Xbox.XboxModel.XBOXSERIESX, models[5]);
    }

    @Test
    public void testDiskDrive() {
        Xbox xbox = new Xbox("XBOXONE", 400, "White", true);
        assertFalse("Disk drive should be empty", xbox.DiskDrive());
    }

    @Test 
    public void testPrintAllGames() {
        Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true);
        loadGames loader = new loadGames("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
        loader.loadGamesFromFile(xbox);
        

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //Calls the printAllGames method
        xbox.printAllGames();

        System,setOut(originalOut);
        String expectedOutput = "Game ID: 1, Game Name: Call of Duty\n" +
                            "Game ID: 2, Game Name: Elden Ring\n" +
                            "Game ID: 3, Game Name: Minecraft\n" +
                            "Game ID: 4, Game Name: Monster Hunter\n" +
                            "Game ID: 5, Game Name: Fortnite\n" +
                            "Game ID: 6, Game Name: Marvel Rivals\n" +
                            "Game ID: 7, Game Name: Tetris\n" +
                            "Game ID: 8, Game Name: Madden NFL\n" +
                            "Game ID: 9, Game Name: Terraria\n" +
                            "Game ID: 10, Game Name: Baldur's Gate 3\n";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());

    

    }
}
