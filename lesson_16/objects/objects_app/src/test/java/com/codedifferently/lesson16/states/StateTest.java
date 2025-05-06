package com.codedifferently.lesson16.states;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTest {

  private State state;

  @BeforeEach
  public void setUp() {
    state = new State("California", "Sacramento", 39500000, 423967, State.Region.WEST);
  }

  @Test
  public void constructor_ShouldInitializeFieldsCorrectly() {
    assertThat(state)
        .extracting("name", "capital", "population", "area", "region")
        .containsExactly("California", "Sacramento", 39500000, 423967.0, State.Region.WEST);
  }

  @Test
  public void updatePopulation_ShouldUpdateCorrectly_WhenValid() throws PopulationTooLowException {
    state.updatePopulation(5000000);
    assertThat(state).extracting("population").isEqualTo(5000000);
  }

  @Test
  public void updatePopulation_ShouldThrowException_WhenTooLow() {
    assertThatThrownBy(() -> state.updatePopulation(9000))
        .isInstanceOf(PopulationTooLowException.class)
        .hasMessage("Population too low for a state!");
  }

  @Test
  public void addMajorCity_ShouldAddCityToList() {
    state.addMajorCity("Los Angeles");
    state.addMajorCity("San Francisco");

    // Check if the cities were added (accessing via reflection for private field)
    assertThat(state)
        .extracting("majorCities")
        .asList()
        .containsExactly("Los Angeles", "San Francisco");
  }

  @Test
  public void listMajorCities_ShouldPrintCityList() {
    state.addMajorCity("Los Angeles");
    state.addMajorCity("San Diego");

    // Capture the output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    state.listMajorCities();

    System.setOut(System.out); // Reset back

    String expectedOutput = "Major cities in California:\n- Los Angeles\n- San Diego\n";
    assertThat(outContent.toString().trim()).isEqualToIgnoringNewLines(expectedOutput.trim());
  }
}
