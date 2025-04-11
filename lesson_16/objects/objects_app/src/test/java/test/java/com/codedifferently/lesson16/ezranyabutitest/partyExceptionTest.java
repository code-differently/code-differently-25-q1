package test.java.com.codedifferently.lesson16.ezranyabutitest;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson16.ezranyabuti.partyException;
import org.junit.jupiter.api.Test;

public class partyExceptionTest {
  // Test for the constructor
  @Test
  void testConstructor() {
    String expectedMessage = "Party is not private";
    partyException exception = new partyException(expectedMessage);
    String actualMessage = exception.getMessage();
    assertThat(actualMessage).isEqualTo(expectedMessage);
  }
}
