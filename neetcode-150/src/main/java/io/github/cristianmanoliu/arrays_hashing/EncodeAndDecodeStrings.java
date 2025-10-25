package io.github.cristianmanoliu.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode?list=neetcode150
// https://leetcode.com/problems/encode-and-decode-strings/description/
public class EncodeAndDecodeStrings {

  /**
   * Encodes a list of strings to a single string using length-prefix encoding.
   * <p>
   * Format: length + "#" + string for each string in the list.
   * <p>
   * Example: ["hello", "world"] -> "5#hello5#world"
   */
  public String encode(List<String> strs) {
    StringBuilder encoded = new StringBuilder();

    for (String str : strs) {
      encoded.append(str.length()).append('#').append(str);
    }

    return encoded.toString();
  }

  /**
   * Decodes a single string back to a list of strings.
   * <p>
   * Parses length-prefix encoding by reading length, then extracting exact character count.
   */
  public List<String> decode(String str) {
    List<String> decoded = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
      // Find the delimiter '#' to extract length
      int delimiterIndex = str.indexOf('#', i);

      // Extract length of the next string
      int length = Integer.parseInt(str.substring(i, delimiterIndex));

      // Extract the string starting after '#'
      int startIndex = delimiterIndex + 1;
      int endIndex = startIndex + length;
      decoded.add(str.substring(startIndex, endIndex));

      // Move to the next encoded string
      i = endIndex;
    }

    return decoded;
  }
}
