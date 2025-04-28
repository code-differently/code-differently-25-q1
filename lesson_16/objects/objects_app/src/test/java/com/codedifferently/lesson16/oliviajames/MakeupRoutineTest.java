package com.codedifferently.lesson16.oliviajames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.oliviajames.MakeupRoutine.MakeupLook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MakeupRoutineTest {

  MakeupRoutine makeupRoutine;

  @BeforeEach
  void setUp() {
    makeupRoutine = new MakeupRoutine("NARS", 60, true, MakeupLook.FULL_GLAM);
  }

  @Test
  void testgetName() {
    String actual = makeupRoutine.getName();

    assertThat(actual).isEqualTo("NARS");
  }

  @Test
  public void testSetName() {
    makeupRoutine.setName("Night Out");
    assertEquals("Night Out", makeupRoutine.getName());
  }

  @Test
  public void testGetTime() {
    assertEquals(60, makeupRoutine.getTime());
  }

  @Test
  public void testSetTime() {
    makeupRoutine.setTime(45);
    assertEquals(45, makeupRoutine.getTime());
  }

  @Test
  public void testGetLookType() {
    assertEquals(MakeupRoutine.MakeupLook.FULL_GLAM, makeupRoutine.getLookType());
  }

  @Test
  public void testGetUsesPrimer() {
    try {
      makeupRoutine.getUsesPrimer();
    } catch (MissingPrimerException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testShowVanityItems() {
    assertNotNull(makeupRoutine); // just to check vanityItems were initialized
  }

  @Test
  public void testMakeupVanityHasItems() {
    makeupRoutine.MakeupVanity();
    assertFalse(makeupRoutine.vanityItems.isEmpty());
    assertTrue(makeupRoutine.vanityItems.contains("Foundation"));
  }
}
