package com.codedifferently.lesson16;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE)
class Lesson16Test {

  @Test
  void testMain() {
    assertThat(new Lesson16()).isNotNull();
  }
}
