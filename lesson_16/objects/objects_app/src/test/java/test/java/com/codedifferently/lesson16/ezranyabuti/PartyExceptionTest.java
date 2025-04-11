package test.java.com.codedifferently.lesson16.ezranyabuti;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson16.ezranyabuti.PartyException;
import org.junit.jupiter.api.Test;

public class PartyExceptionTest {
  // Test for the constructor
  @Test
  void testConstructor() {
    String expectedMessage = "Party is not private";
    PartyException exception = new PartyException(expectedMessage);
    String actualMessage = exception.getMessage();
    assertThat(actualMessage).isEqualTo(expectedMessage);
  }
}
