package io.github.cristianmanoliu.bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for NumberOfOneBits
class NumberOfOneBitsTest {

  private final NumberOfOneBits sol = new NumberOfOneBits();

  @Test
  @DisplayName("Zero has no set bits")
  void zero() {
    assertEquals(0, sol.hammingWeight(0));
  }

  @Test
  @DisplayName("Small positive: 11 (0b1011) -> 3")
  void smallPositive() {
    assertEquals(3, sol.hammingWeight(11)); // 1011
  }

  @Test
  @DisplayName("Single set bit: powers of two -> 1")
  void powersOfTwo() {
    assertEquals(1, sol.hammingWeight(1));
    assertEquals(1, sol.hammingWeight(2));
    assertEquals(1, sol.hammingWeight(4));
    assertEquals(1, sol.hammingWeight(1 << 30));
  }

  @Test
  @DisplayName("All ones: -1 has 32 set bits in two's complement")
  void allOnes() {
    assertEquals(32, sol.hammingWeight(-1));
  }

  @Test
  @DisplayName("Negative numbers: compare against Integer.bitCount")
  void negatives() {
    assertEquals(Integer.bitCount(-3), sol.hammingWeight(-3));
    assertEquals(Integer.bitCount(Integer.MIN_VALUE), sol.hammingWeight(Integer.MIN_VALUE));
  }

  @Test
  @DisplayName("Randomized comparison vs Integer.bitCount")
  void randomized() {
    Random rnd = new Random(42);
    for (int i = 0; i < 1_000; i++) {
      int x = rnd.nextInt();
      assertEquals(Integer.bitCount(x), sol.hammingWeight(x));
    }
  }
}