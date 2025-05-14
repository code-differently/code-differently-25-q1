package com.davidadenaike;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ShinobiTest {
    
    @Test
    public void testCreateNormalShinobi() throws RogueShinobiExcLeseption {
        Village village = new Village("Leaf");
        Shinobi naruto = new Shinobi("Naruto", village, "Genin");
        
        assertEquals("Naruto", naruto.getName());
        assertEquals("Genin", naruto.getRank());
        assertEquals('D', naruto.getMissionRank());
    }

    @Test
    public void testCreateRogueShinobi() {
        Village village = new Village("Leaf");
        assertThrows(RogueShinobiException.class, () -> {
            new Shinobi("Sasuke", village, "rogue");
        });
    }

    @Test
    public void testPromotionEligibility() throws RogueShinobiException {
        Village village = new Village("Leaf");
        Shinobi sasuke = new Shinobi("Sasuke", village, "Genin");
        
        // Add requirements for Chunin
        sasuke.setMissionRank('A');
        for(int i = 0; i < 5; i++) {
            sasuke.addJutsu("Jutsu" + i);
        }
        
        assertTrue(sasuke.checkForPromotion());
    }

    @Test
    public void testAddJutsu() throws RogueShinobiException {
        Village village = new Village("Leaf");
        Shinobi kakashi = new Shinobi("Kakashi", village, "Jōnin");
        
        kakashi.addJutsu("Chidori");
        assertTrue(kakashi.getJutsus().contains("Chidori"));
        assertEquals(1, kakashi.getJutsus().size());
    }

    @Test
    public void testRyoManagement() throws RogueShinobiException {
        Village village = new Village("Leaf");
        Shinobi sakura = new Shinobi("Sakura", village, "Chūnin");
        
        assertEquals(0, sakura.getRyo());
        sakura.addRyo(1000);
        assertEquals(1000, sakura.getRyo());
    }
}
