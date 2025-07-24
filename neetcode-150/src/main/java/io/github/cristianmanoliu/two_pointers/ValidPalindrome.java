package io.github.cristianmanoliu.two_pointers;

public class ValidPalindrome {

  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);

      if (!Character.isLetterOrDigit(rightChar)) {
        right--;
        continue;
      }

      if (!Character.isLetterOrDigit(leftChar)) {
        left++;
        continue;
      }

      if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
