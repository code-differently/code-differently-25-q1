package com.codedifferently.lesson16;


import org.junit.jupiter.api.Test;

public class MakeupRoutineTest{

MakeupRoutine makeupRoutine;

@BeforeEach
void setUp() {
makeupRoutine = new MakeupRoutine("NARS", 60, true, "DEWY")
}

  @Test
  void testgetName() {
String actual = makeupRoutine.getName();

assertThat(actual).isEqualTo("NARS");
}





  /*public void testGetLook() {
    MakeupRoutine routine =
        new MakeupRoutine("Soft Glam", "Foundation", 5, GlamRank.SOFT_GLAM, 120.00);
    GlamRank expected = GlamRank.SOFT_GLAM;
    assertThat(routine.getRank()).isEqualTo(expected);
  }

  @Test
  public void testSetBaseProduct() {
    MakeupRoutine routine =
        new MakeupRoutine("Natural", "BB Cream", 3, GlamRank.NATURAL_BADDIE, 85.50);
    routine.setBaseProduct("Tinted Moisturizer");
    String expected = "Tinted Moisturizer";
    assertThat(routine.getBaseProduct()).isEqualTo(expected);
  }

  @Test
  public void testSetTotalCost() {
    MakeupRoutine routine =
        new MakeupRoutine("Full Glam", "Full Coverage Foundation", 8, GlamRank.FULL_GLAM, 200.00);
    routine.setTotalCost(220.00);
    double expected = 220.00;
    assertThat(routine.getTotalCost()).isEqualTo(expected);
  }

  @Test
  public void testAddStep() {
    MakeupRoutine routine =
        new MakeupRoutine("Glow", "Light Coverage", 6, GlamRank.FULL_GLAM, 88.00);
    String step = "add mascara";
    routine.addStep(step);
    steps = routine.getSteps();
    if (steps.contains(step)) {
      System.out.println("Step add mascara is in the list");

    } else {
      System.out.println("Step add mascara is not in the list");
    }
  }*/
}
