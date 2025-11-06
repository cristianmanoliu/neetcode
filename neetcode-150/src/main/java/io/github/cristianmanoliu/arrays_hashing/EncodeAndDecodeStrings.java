package io.github.cristianmanoliu.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode?list=neetcode150
// https://leetcode.com/problems/encode-and-decode-strings/description/
public class EncodeAndDecodeStrings {

  // Main function: encode a list of strings into a single string.
  // Strategy: Use length-prefix encoding with a delimiter '#':
  // For each s in strs, append:  s.length() + '#' + s
  // This is safe even if s contains '#' or digits, because we first read the numeric length.
  public String encode(List<String> strs) {
    // Use StringBuilder for efficient concatenation
    StringBuilder encoded = new StringBuilder();

    // Append each string as "<len>#<content>"
    for (String str : strs) {
      encoded.append(str.length()).append('#').append(str);
    }

    // Return the combined payload
    return encoded.toString();
  }

  // Main function: decode a single encoded string back into the original list of strings.
  // We scan left-to-right:
  // - Read the number before the next '#': that's the length L of the next string
  // - Then take the next L characters as the string
  // - Move the pointer forward and repeat
  public List<String> decode(String str) {
    // Output list to collect decoded strings
    List<String> decoded = new ArrayList<>();
    // Read pointer into the encoded string
    int i = 0;

    // Process until we've consumed the entire encoded string
    while (i < str.length()) {
      // Find the next '#' delimiter after index i (end of the length field)
      int delimiterIndex = str.indexOf('#', i);

      // Parse the substring [i, delimiterIndex) as the integer length
      int length = Integer.parseInt(str.substring(i, delimiterIndex));

      // Extract the next 'length' characters as the string payload
      int startIndex = delimiterIndex + 1;
      int endIndex = startIndex + length;
      decoded.add(str.substring(startIndex, endIndex));

      // Advance pointer to the start of the next length field
      i = endIndex;
    }

    // Return all reconstructed strings
    return decoded;
  }
}
