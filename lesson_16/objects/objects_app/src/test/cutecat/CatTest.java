package com.codedifferently.lesson16.cutecat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CatTest {

    @Test 
    public void testCreateNinjaCat() throws InvalidCatNameException {
        Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true);
        assertEquals("Ninja", cat.getName());
        assertEquals(13, cat.getAge());
        assertEquals(9.3, cat.getWeight());
        assertTrue(cat.getIsIndoor());
        assertEquals(Breed.MAINCOON, cat.getBreed());
    }

    @Test
    public void testfavoriteFoodsDefault() throws InvalidCatNameException {
        Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true);
        ArrayList<String> foods = cat.getfavoriteFoods();
        assertTrue(foods.contains("Fancy Feast"));
        assertTrue(foods.contains("Purina Naturals"));
        assertEquals(2, foods.size());      
    }

    @Test 
    public void testPrintFavoriteFoodsCoverage() throws InvalidCatNameException {
        Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true);
        cat.printfavoriteFoods(); 
    }

    @Test
    public void testAddFavoriteFood() throws InvalidCatNameException {
        Cat cat = new Cat("Ninja", 13,9.3, Breed.MAINCOON, true);
        cat.addfavoriteFood("Tuna");
        ArrayList<String> foods = cat.getfavoriteFoods();
        assertTrue(foods.contains("Tuna"));
        assertEquals(3, foods.size());
    }

    @Test
    public void testIsSenior() throws InvalidCatNameException {
        Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true);
        assertTrue(cat.isSenior());
    }

    @Test
    public void testInvalidNameThrowsException() {
        assertThrows(InvalidCatNameException.class, () -> {
            new Cat("", 13, 9.3, Breed.MAINCOON, true);
        });       
    }
    
}