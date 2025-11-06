package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for EncodeAndDecodeStrings
class EncodeAndDecodeStringsTest {

  private final EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();

  @Test
  @DisplayName("Empty list encodes to empty string and decodes back to empty list")
  void emptyListRoundTrip() {
    List<String> input = List.of();
    String encoded = codec.encode(input);
    assertEquals("", encoded);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Single simple string")
  void singleString() {
    List<String> input = List.of("hello");
    String encoded = codec.encode(input);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Multiple strings with varying lengths")
  void multipleStrings() {
    List<String> input = List.of("leet", "code", "is", "fun");
    String encoded = codec.encode(input);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Strings containing '#' and digits are handled safely by length-prefix")
  void stringsWithHashesAndDigits() {
    List<String> input = List.of("#", "12#34", "a#b#c", "###", "2025");
    String encoded = codec.encode(input);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Strings including empty elements")
  void includesEmptyStrings() {
    List<String> input = List.of("", "a", "", "bc", "");
    String encoded = codec.encode(input);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Unicode and emoji content")
  void unicodeAndEmoji() {
    List<String> input = List.of("salut", "😊🚀", "中文字符", "café", "🍀");
    String encoded = codec.encode(input);
    assertEquals(input, codec.decode(encoded));
  }

  @Test
  @DisplayName("Decode directly from a known encoded payload")
  void decodeKnownPayload() {
    // "hi", "", "abc" -> "2#hi0#3#abc"
    String encoded = "2#hi0#3#abc";
    List<String> expected = List.of("hi", "", "abc");
    assertEquals(expected, codec.decode(encoded));
  }
}