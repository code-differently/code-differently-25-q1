package com.codedifferently.lesson16.cutecat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class CatTest {

  @Test
  public void testCreateNinjaCat() throws InvalidCatNameException {
    Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true, false);
    assertEquals("Ninja", cat.getName());
    assertEquals(13, cat.getAge());
    assertEquals(9.3, cat.getWeight());
    assertTrue(cat.getIsIndoor());
    assertEquals(Breed.MAINCOON, cat.getBreed());
  }

  @Test
  public void testfavoriteFoodsDefault() throws InvalidCatNameException {
    Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true, false);
    ArrayList<String> foods = cat.getfavoriteFoods();
    assertTrue(foods.contains("Fancy Feast"));
    assertTrue(foods.contains("Purina Naturals"));
    assertEquals(2, foods.size());
  }

  @Test
  public void testPrintFavoriteFoodsCoverage() throws InvalidCatNameException {
    Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true, false);
    cat.printfavoriteFoods();
  }

  @Test
  public void testAddFavoriteFood() throws InvalidCatNameException {
    Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true, false);
    cat.addfavoriteFood("Tuna");
    ArrayList<String> foods = cat.getfavoriteFoods();
    assertTrue(foods.contains("Tuna"));
    assertEquals(3, foods.size());
  }

  @Test
  public void testIsSenior() throws InvalidCatNameException {
    Cat cat = new Cat("Ninja", 13, 9.3, Breed.MAINCOON, true, false);
    assertTrue(cat.isSenior());
  }

  @Test
  public void testCatName() throws InvalidCatNameException {
    Cat cat = new Cat("Whiskers", 5, 5.4, Breed.SPHYNX, false, true);
    assertEquals("Whiskers", cat.getName());
  }

  @Test
  public void testCatMeow() throws InvalidCatNameException {
    Cat cat = new Cat("Mittens", 2, 8.9, Breed.SIAMESE, true, true);
    assertEquals("Meow!", cat.meow());
  }

  @Test
  public void testGetName() throws InvalidCatNameException {
    Cat cat = new Cat("Shadow", 2, 7.4, Breed.BENGAL, true, true);
    assertEquals("Shadow", cat.getName());
  }

  @Test
  public void testGetAge() throws InvalidCatNameException {
    Cat cat = new Cat("Nine", 2, 13.2, Breed.MAINCOON, true, false);
    assertEquals(2, cat.getAge());
  }

  @Test
  public void testMeow() throws InvalidCatNameException {
    Cat cat = new Cat("Frisky", 2, 5.4, Breed.UNKNOWN, true, true);
    assertEquals("Meow!", cat.meow());
  }

  @Test
  public void testWalk() throws InvalidCatNameException {
    Cat cat = new Cat("Shadow", 2, 7.4, Breed.BENGAL, true, false);
    assertEquals("Shadow is walking.", cat.walk());
  }

  @Test
  public void testSleep() throws InvalidCatNameException {
    Cat cat = new Cat("Shadow", 2, 7.4, Breed.BENGAL, true, false);
    assertEquals("Shadow is sleeping.", cat.sleep());
  }

  @Test
  public void testisKittenTrue() throws InvalidCatNameException {
    Cat cat = new Cat("Tiny", 0, 2.5, Breed.PERSIAN, true, true);
    assertTrue(cat.isKitten());
  }

  @Test
  public void testIsKittenFalse() throws InvalidCatNameException {
    Cat cat = new Cat("Trinity", 3, 5.6, Breed.UNKNOWN, true, true);
    assertFalse(cat.isKitten());
  }
}
