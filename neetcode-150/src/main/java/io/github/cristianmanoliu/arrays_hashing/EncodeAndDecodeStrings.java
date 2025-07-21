package io.github.cristianmanoliu.arrays_hashing;

import java.util.List;

public class EncodeAndDecodeStrings {

  public String encode(List<String> strs) {
    if (strs == null || strs.isEmpty()) {
      return ""; // Return empty string if input is null or empty
    }
    StringBuilder encoded = new StringBuilder();
    for (String str : strs) {
      if (str != null) {
        // Append the length of the string followed by a delimiter and the string itself
        encoded.append(str.length()).append('#').append(str);
      }
    }
    // Return the encoded string
    return encoded.toString();
  }

  public List<String> decode(String str) {
    if (str == null || str.isEmpty()) {
      return List.of(); // Return empty list if input is null or empty
    }

    List<String> decoded = new java.util.ArrayList<>();
    int i = 0;

    while (i < str.length()) {
      // Find the delimiter '#'
      int delimiterIndex = str.indexOf('#', i);
      if (delimiterIndex == -1) {
        break; // No more delimiters found, exit the loop
      }

      // Extract the length of the string
      int length = Integer.parseInt(str.substring(i, delimiterIndex));
      i = delimiterIndex + 1; // Move past the delimiter

      // Extract the string based on the length
      String substring = str.substring(i, i + length);
      decoded.add(substring);

      // Move index forward by the length of the string plus the delimiter
      i += length;
    }

    return decoded; // Return the list of decoded strings
  }
}
