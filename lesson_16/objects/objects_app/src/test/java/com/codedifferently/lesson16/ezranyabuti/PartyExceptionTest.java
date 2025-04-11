package com.codedifferently.lesson16.ezranyabuti;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PartyExceptionTest {
  @Test
  void testConstructor() {
    String expectedMessage = "Party is not private";
    PartyCityException exception = new PartyCityException(expectedMessage);
    String actualMessage = exception.getMessage();
    assertThat(actualMessage).isEqualTo(expectedMessage);
  }
}
