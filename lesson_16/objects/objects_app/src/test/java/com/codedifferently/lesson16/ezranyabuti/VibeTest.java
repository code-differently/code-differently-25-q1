package com.codedifferently.lesson16.ezranyabuti;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VibeTest {

  @Test
  void testVibeEnum() {
    Vibe[] expectedVibes = {
      Vibe.CHILL, Vibe.PRIVATE, Vibe.ALL_WHITE, Vibe.RELAXED_LOUNGE, Vibe.COSTUME
    };
    Vibe[] actualVibes = Vibe.values();
    assertThat(actualVibes).containsExactly(expectedVibes);
  }

  @Test
  void testVibeEnumNames() {
    String[] expectedNames = {"CHILL", "PRIVATE", "ALL_WHITE", "RELAXED_LOUNGE", "COSTUME"};
    String[] actualNames = new String[expectedNames.length];
    for (int i = 0; i < expectedNames.length; i++) {
      actualNames[i] = Vibe.values()[i].name();
    }
    assertThat(actualNames).containsExactly(expectedNames);
  }
}
