package com.codedifferently.lesson16.strengthmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.strengthmachine.StrengthMachine.MuscleGroup;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrengthMachineTest {

  StrengthMachine strengthMachine;

  @BeforeEach
  void setUp() {
    strengthMachine =
        new StrengthMachine(
            "Leg Press",
            100,
            false,
            new ArrayList<>(Arrays.asList("Keep back straight.", "Use a spotter for heavy lifts.")),
            StrengthMachine.MuscleGroup.LEGS);
  }

  @Test
  public void testIsAvailableTrue() {
    assertTrue(strengthMachine.isAvailable());
  }

  @Test
  public void testIsAvailableFalse() {
    strengthMachine.useMachine();
    assertFalse(strengthMachine.isAvailable());
  }

  @Test
  public void testIncreaseWeightGradually() {
    strengthMachine.increaseWeightGradually(125);
    int actual = strengthMachine.getCurrentWeight();
    assertThat(actual).isEqualTo(125);
  }

  @Test
  public void testAddSafetyTip() {
    strengthMachine.addSafetyTip("Do not lock your joints.");
    assertThat(strengthMachine.getSafetyTips().size()).isEqualTo(3);
  }

  @Test
  public void testUseMachineAvailable() {
    strengthMachine.useMachine();
    assertFalse(strengthMachine.isAvailable());
  }

  @Test
  public void testUseMachineException() {
    strengthMachine.useMachine();

    assertThatThrownBy(() -> strengthMachine.useMachine())
        .isInstanceOf(MachineInUseException.class)
        .hasMessage("Cannot use - Machine currently in use");
  }

  @Test
  public void testGetName() {
    // Act
    String actual = strengthMachine.getName();

    // Assert
    assertThat(actual).isEqualTo("Leg Press");
  }

  @Test
  public void testSetName() {
    // Act
    strengthMachine.setName("Leg Curl");
    String actual = strengthMachine.getName();

    // Assert
    assertThat(actual).isEqualTo("Leg Curl");
  }

  @Test
  public void testGetCurrentWeight() {
    // Act
    int actual = strengthMachine.getCurrentWeight();

    // Assert
    assertThat(actual).isEqualTo(100);
  }

  @Test
  public void testSetCurrentWeight() {
    // Act
    strengthMachine.setCurrentWeight(150);
    int actual = strengthMachine.getCurrentWeight();

    // Assert
    assertThat(actual).isEqualTo(150);
  }

  @Test
  public void testGetInUse() {
    // Act
    boolean actual = strengthMachine.getInUse();

    // Assert
    assertThat(actual).isEqualTo(false);
  }

  @Test
  public void testSetInUse() {
    // Act
    strengthMachine.setInUse(true);
    boolean actual = strengthMachine.getInUse();

    // Assert
    assertThat(actual).isEqualTo(true);
  }

  @Test
  public void testGetSafetyTips() {
    // Act
    ArrayList<String> actual = strengthMachine.getSafetyTips();

    // Assert
    assertThat(actual.size()).isEqualTo(2);
    assertThat(actual.get(0)).isEqualTo("Keep back straight.");
    assertThat(actual.get(1)).isEqualTo("Use a spotter for heavy lifts.");
  }

  @Test
  public void testSetSafetyTips() {
    // Arrange
    ArrayList<String> newTips =
        new ArrayList<>(Arrays.asList("Bend knees slightly.", "Do not lock your joints."));
    // Act
    strengthMachine.setSafetyTips(newTips);
    ArrayList<String> actual = strengthMachine.getSafetyTips();

    // Assert
    assertThat(actual.size()).isEqualTo(2);
    assertThat(actual.get(0)).isEqualTo("Bend knees slightly.");
    assertThat(actual.get(1)).isEqualTo("Do not lock your joints.");
  }

  @Test
  public void testGetTargetMuscle() {
    // Act
    MuscleGroup actual = strengthMachine.getTargetMuscle();

    // Assert
    assertThat(actual).isEqualTo(StrengthMachine.MuscleGroup.LEGS);
  }

  @Test
  public void testSetTargetMuscle() {
    // Act
    strengthMachine.setTargetMuscle(StrengthMachine.MuscleGroup.BACK);
    MuscleGroup actual = strengthMachine.getTargetMuscle();

    // Assert
    assertThat(actual).isEqualTo(StrengthMachine.MuscleGroup.BACK);
  }
}
