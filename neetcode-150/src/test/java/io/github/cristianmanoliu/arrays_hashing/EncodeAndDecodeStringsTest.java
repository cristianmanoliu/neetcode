package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class EncodeAndDecodeStringsTest {

  private final EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();

  @Test
  public void testEncodeAndDecode() {
    // Test case with multiple strings
    List<String> input = List.of("hello", "world", "this", "is", "a", "test");
    String encoded = encodeAndDecodeStrings.encode(input);
    List<String> decoded = encodeAndDecodeStrings.decode(encoded);
    assertEquals(input, decoded);
  }
}