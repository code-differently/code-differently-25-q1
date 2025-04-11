package com.codedifferently.lesson17;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;

@SpringBootTest(useMainMethod = UseMainMethod.WHEN_AVAILABLE)
class Lesson17Test {

  @Test
  void testInstantiate() {
    assertThat(new Lesson17()).isNotNull();
  }
}
