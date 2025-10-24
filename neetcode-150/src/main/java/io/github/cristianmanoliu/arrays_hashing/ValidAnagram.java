package io.github.cristianmanoliu.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/is-anagram?list=neetcode150
public class ValidAnagram {

  // Anagram: a word, phrase, or name formed by rearranging the letters of another,
  // such as cinema, formed from iceman.
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    List<Character> leftChars = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      leftChars.add(s.charAt(i));
    }
    List<Character> rightChars = new ArrayList<>();
    for (int j = 0; j < t.length(); j++) {
      rightChars.add(t.charAt(j));
    }
    leftChars.sort(Character::compareTo);
    rightChars.sort(Character::compareTo);

    return leftChars.equals(rightChars);
  }

}
