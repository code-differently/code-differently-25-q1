package com.codedifferently.lesson9.generator;

import com.google.common.base.Joiner;
import java.util.Collections;
import java.util.stream.Collectors;

public class Generators {

  public static class IntValueGenerator implements ValueGenerator {
    public String generateValue() {
      int minValue = (int) Short.MAX_VALUE + 1;
      var maxValue = Integer.MAX_VALUE;
      var value = (int) (minValue + Math.random() * (maxValue - minValue - 1));
      return Integer.toString(value);
    }
  }

  public static class StringValueGenerator implements ValueGenerator {
    public String generateValue() {
      var chars =
          "abcdefghijklmnopqrstuvwxyz1234567890"
              .chars()
              .mapToObj(c -> (char) c)
              .collect(Collectors.toList());
      Collections.shuffle(chars);
      int minLength = 5 + (int) (Math.random() * 8);
      return Joiner.on("").join(chars.subList(0, minLength));
    }
  }

  public static class DoubleValueGenerator implements ValueGenerator {
    public String generateValue() {
      return Math.random() * Double.MAX_VALUE - 0.123456789012345d + "";
    }
  }

  public static class ShortValueGenerator implements ValueGenerator {
    public String generateValue() {
      short minValue = 1;
      var maxValue = Short.MAX_VALUE;
      var value = (short) (minValue + Math.random() * (maxValue - minValue - 1));
      return Short.toString(value);
    }
  }

  public static class LongValueGenerator implements ValueGenerator {
    public String generateValue() {
      long minValue = Integer.MAX_VALUE + 1L;
      var maxValue = Long.MAX_VALUE;
      var value = (long) (minValue + Math.random() * (maxValue - minValue - 1));
      return Long.toString(value);
    }
  }

  public static class FloatValueGenerator implements ValueGenerator {
    public String generateValue() {
      return (float) (Math.random() * Float.MAX_VALUE) + "";
    }
  }

  public static class BooleanValueGenerator implements ValueGenerator {
    public String generateValue() {
      return Math.random() > 0.5 ? "true" : "false";
    }
  }
}
