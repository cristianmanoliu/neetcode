package io.github.cristianmanoliu.stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    // Stack to keep track of opening parentheses
    java.util.Stack<Character> stack = new java.util.Stack<>();
    // Map to match closing parentheses with opening ones
    java.util.Map<Character, Character> parenthesesMap = new java.util.HashMap<>();
    parenthesesMap.put(')', '(');
    parenthesesMap.put(']', '[');
    parenthesesMap.put('}', '{');
    // Iterate through each character in the string
    for (char c : s.toCharArray()) {
      // If it's an opening parenthesis, push it onto the stack
      if (parenthesesMap.containsValue(c)) {
        stack.push(c);
      }
      // If it's a closing parenthesis, check if it matches the top of the stack
      else if (parenthesesMap.containsKey(c)) {
        // If the stack is empty or the top of the stack doesn't match, return false
        if (stack.isEmpty() || stack.peek() != parenthesesMap.get(c)) {
          return false;
        }
        // If it matches, pop the top of the stack
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
