# NeetCode-150

https://neetcode.io/practice?tab=neetcode150

> Note: Big-O notation describes asymptotic growth. It is commonly used to denote an upper bound (often the worst-case) unless an average or best case is
> explicitly stated.

## Big O Notation - Time and Space Complexity

### Time Complexity

O(1) - Constant Time

- The running time does not grow with input size.
- Example: Accessing an element in an array by index.

O(log n) - Logarithmic Time

- The running time grows in proportion to the logarithm of the input size.
- Example: Binary search in a sorted array (each step halves the search space).

O(n) - Linear Time

- The running time grows linearly with the input size.
- Example: Iterating through an array.

O(n log n) - Linearithmic Time

- The running time grows on the order of n·log n.
- Example: Efficient comparison-based sorting algorithms such as Merge Sort (worst-case O(n log n)) and Quick Sort (average-case O(n log n), worst-case O(n^2)).

O(n^2) - Quadratic Time

- The running time grows proportionally to the square of the input size.
- Example: Nested loops over the input, such as in simple implementations of Bubble Sort or insertion-sort-like nested comparisons.

O(2^n) - Exponential Time

- The running time grows exponentially, on the order of 2^n (roughly doubles when n increases by 1).
- Example: Recursive algorithms that solve problems by exploring all subsets or choices (e.g., generating all subsets / naive exponential search). The Tower of
  Hanoi recurrence also yields exponential time O(2^n).

O(n!) - Factorial Time

- The running time grows factorially with the input size, on the order of n!.
- Example: Generating all permutations of a set (if you explicitly enumerate and store them).

### Space Complexity

O(1) - Constant Space

- The extra space required does not grow with input size (only a fixed number of variables).
- Example: Using a fixed number of variables.

O(log n) - Logarithmic Space

- The extra space grows proportional to the logarithm of the input size.
- Example: Recursion depth for divide-and-conquer algorithms on balanced inputs, e.g., recursive binary search uses O(log n) stack space.

O(n) - Linear Space

- The extra space grows linearly with the input size.
- Example: Allocating an additional array of size n.

O(n log n) - Linearithmic Space (uncommon)

- The extra space grows on the order of n·log n.
- Typical divide-and-conquer algorithms use O(n) or O(log n) extra space; O(n log n) space is not typical.
- Examples:
    - Sparse Table for RMQ precomputes n·⌊log2 n⌋ values.
    - Binary lifting (jump pointers) for LCA stores O(log n) parent pointers per node, totaling O(n log n) space.

O(n^2) - Quadratic Space

- The extra space grows proportional to n^2.
- Example: Storing a 2D matrix of size n × n.

O(2^n) - Exponential Space

- The extra space grows on the order of 2^n.
- Example: Storing all subsets of a set (power set) explicitly requires O(2^n) space.

O(n!) - Factorial Space

- The extra space grows on the order of n!.
- Example: Storing all permutations of a set.

### Summary

- Time Complexity: O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)
- Space Complexity: O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)

Usually O(1) and O(log n) are considered very efficient.

---

## Arrays & Hashing

### [Easy] Contains Duplicate

Scan once using a hash set: for each `x`, if `x` is already in the set return `true`; otherwise add it; if the loop ends, return `false`.

**Time:** O(n)
**Space:** O(n)

### [Easy] Valid Anagram

If lengths match, count chars from `s` and decrement with `t`; if any decrement goes negative or a char is missing, return false; else true (use int[26] for
lowercase).

**Time:** O(n)
**Space:** O(1) with fixed alphabet (otherwise O(k)).

### [Easy] Two Sum

Single-pass scan with a hash map `{value → index}`: for each `x` at `i`, if `target - x` is in the map return `[map[target - x], i]`, else store `map[x] = i`.

**Time:** O(n)
**Space:** O(n)

### [Medium] Group Anagrams

Group strings in a hash map keyed by their canonical form—either `sorted(s)` or a 26-length count tuple—and return the map’s values.

**Time:** O(n·k log k) with sorting, O(n·k) with counts
**Space:** O(n·k)

### [Medium] Top K Frequent Elements

Count frequencies with a hash map, stream `(freq, val)` into a size-`k` min-heap (evict smallest when >k), then read heap contents as the top-k.

**Time:** O(n log k)
**Space:** O(n)

### [Medium] Encode and Decode Strings

**One-line:** Encode by concatenating `len(s) + '#' + s` for each string; decode by scanning numbers up to `'#'` to get `len`, then slicing the next `len`
chars, repeating to the end.

**Time:** O(n) over total characters
**Space:** O(n) for encoded/decoded output.

### [Medium] Product of Array Except Self

Fill `out[i]` with prefix products in a left-to-right pass, then traverse right-to-left keeping a running suffix product and multiply into `out[i]` to get
product-except-self.

**Time:** O(n)
**Space:** O(1) extra (excluding output).

### [Medium] Valid Sudoku

**One-line:** Scan all 81 cells; for each digit at (r,c), compute `b = (r//3)*3 + (c//3)` and check/insert into `rows[r]`, `cols[c]`, and `boxes[b]`; if any
already contains it, return `false`, else continue and return `true`.

**Time:** O(1) (81 cells)
**Space:** O(1) (fixed sets)

### [Medium] Longest Consecutive Sequence

Put all numbers in a set; for each `x` where `x-1` isn’t in the set, walk forward `x, x+1, …` counting length and update a running maximum.

**Time:** O(n)
**Space:** O(n)

## Two Pointers

### [Easy] Valid Palindrome

**Main idea**:
Use a two-pointer approach to check if a string is a palindrome. Start with pointers at both ends of the string:

- **Initialize pointers**: Set left pointer at index 0 and right pointer at the last index
- **Advance toward center**: While left < right:
    - Skip non-alphanumeric characters: increment left while character is not alphanumeric
    - Skip non-alphanumeric characters: decrement right while character is not alphanumeric
    - **Compare characters**: Compare characters at both pointers (case-insensitive)
        - If characters match: move left pointer right (left++) and right pointer left (right--)
        - If characters don't match: return false
- **Return true**: If pointers cross without finding mismatches

The key insight: By processing from both ends simultaneously and skipping non-alphanumeric characters, we efficiently validate palindrome properties in a single
pass without modifying the string.

**Edge cases**: Empty string and single character strings are valid palindromes.

**Time Complexity**: O(n) - single pass through the string with both pointers converging
**Space Complexity**: O(1) - only constant extra space for pointers

### [Medium] Two Sum II - Input Array Is Sorted

**Main idea**:
Use a two-pointer approach to find two numbers that sum to the target. Leverage the sorted property of the array:

- **Initialize pointers**: Set left pointer at index 0 and right pointer at the last index
- **Calculate current sum**: While left < right:
    - Compute sum: current_sum = numbers[left] + numbers[right]
    - **Check against target**:
        - If current_sum == target: return [left + 1, right + 1] (1-based indexing)
        - If current_sum < target: move left pointer right (left++) to increase sum
        - If current_sum > target: move right pointer left (right--) to decrease sum
- **Continue**: Repeat until target is found

The key insight: Since the array is sorted, moving the left pointer increases the sum and moving the right pointer decreases it. This guarantees finding the
solution in O(n) time without needing extra space for a hash map.

**Edge cases**: The problem guarantees exactly one solution exists. Minimum array size is 2.

**Time Complexity**: O(n) - single pass through the array with both pointers converging
**Space Complexity**: O(1) - only constant extra space for pointers

### [Medium] 3Sum

**Main idea**:
Sort the array to enable efficient duplicate handling and two-pointer searching. Iterate through the array fixing one element at a time:

- **Sort the array**: Enable ordered traversal and efficient duplicate skipping
- **Iterate with fixed element**: For each index i from 0 to n-3:
    - Skip duplicate fixed elements: if i > 0 and nums[i] == nums[i-1], continue
    - Set target: target = -nums[i]
    - **Initialize two pointers**: left = i + 1, right = n - 1
    - **Two-pointer search**: While left < right:
        - Calculate sum: current_sum = nums[left] + nums[right]
        - If current_sum == target:
            - Add triplet [nums[i], nums[left], nums[right]] to result
            - Move both pointers: left++, right--
            - Skip duplicate left values: while left < right and nums[left] == nums[left-1], increment left
            - Skip duplicate right values: while left < right and nums[right] == nums[right+1], decrement right
        - If current_sum < target: move left pointer right (left++)
        - If current_sum > target: move right pointer left (right--)
- **Return result**: List of unique triplets

The key insight: Sorting allows us to use the two-pointer technique efficiently and skip duplicates systematically. For a fixed first element, the problem
reduces to finding two numbers that sum to a target, which is solvable in O(n) time with two pointers.

**Edge cases**: Arrays with fewer than 3 elements return empty result.

**Time Complexity**: O(n²) - O(n log n) for sorting + O(n²) for nested iteration (n iterations × O(n) two-pointer search)
**Space Complexity**: O(1) or O(n) - depending on sorting algorithm used (not counting output space)

### [Medium] Container With Most Water

**Main idea**:
Use a two-pointer approach to find the maximum area. Start with pointers at both ends of the array:

- **Initialize pointers and variables**: Set left pointer at index 0 and right pointer at the last index, initialize max_area to 0
- **Calculate current area**: Compute area using formula: area = min(height[left], height[right]) × (right - left)
- **Update maximum**: If current area exceeds max_area, update max_area
- **Move pointer strategically**:
    - If height[left] < height[right]: move left pointer right (left++)
    - Else: move right pointer left (right--)
- **Continue**: Repeat until left and right pointers meet

The key insight: Moving the pointer pointing to the shorter line is optimal because the area is constrained by the shorter height. Moving the taller line's
pointer would only decrease width without potential for increasing height, guaranteeing a smaller area.

**Edge cases**: Array must have at least 2 elements. All heights of 0 return 0 area.

**Time Complexity**: O(n) - single pass through the array with both pointers converging
**Space Complexity**: O(1) - only constant extra space for pointers and tracking variables

### [Hard] Trapping Rain Water

**Main idea**:
Use a two-pointer approach to calculate trapped water in a single pass. Start with pointers at both ends of the array:

- **Initialize pointers and variables**: Set left and right pointers at array boundaries, and left_max and right_max to 0, total water to 0
- **Compare boundary heights**: While left < right, compare height[left] and height[right]
- **Process left side** (if height[left] < height[right]):
    - If height[left] >= left_max: update left_max
    - Else: add (left_max - height[left]) to total water
    - Move left pointer right
- **Process right side** (if height[left] >= height[right]):
    - If height[right] >= right_max: update right_max
    - Else: add (right_max - height[right]) to total water
    - Move right pointer left
- **Continue**: Repeat until pointers meet

The key insight: At each step, water trapped at current position depends on the minimum of the maximum heights seen from both sides. We process from the side
with the smaller height because that height definitively bounds the water level at that position—we don't need to know the exact maximum from the other side
since we know it's at least as tall.

**Edge cases**: Arrays with fewer than 3 elements cannot trap water. All equal heights trap 0 water.

**Time Complexity**: O(n) - single pass through the array with both pointers
**Space Complexity**: O(1) - only constant extra space

## Sliding Window

### [Easy] Best Time to Buy and Sell Stock

**Main idea**:
Use a single pass through the array to track the minimum price seen so far and calculate the maximum profit at each step. Iterate through the prices:

- **Initialize variables**: Set minimum price to infinity (or first price) and maximum profit to 0
- **Expand iteration**: Move through each price in the array
- **Calculate potential profit**: For current price, compute profit as (current price - minimum price)
- **Update maximum**: If current profit exceeds maximum profit, update maximum profit
- **Update minimum**: If current price is lower than minimum price, update minimum price
- **Continue**: Repeat until all prices are processed

**Time Complexity**: O(n) - single pass through the array
**Space Complexity**: O(1) - only constant extra space for tracking minimum price and maximum profit

### [Medium] Longest Substring Without Repeating Characters

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring. Iterate through the string:

- **Initialize hash set**: Track characters currently in the window
- **Expand window**: Move right pointer to include new characters
- **Check for duplicates**: If current character already exists in the set:
    - Shrink window from left by removing characters until duplicate is removed
    - Move left pointer right and update the set
- **Add character**: Add current character to the set
- **Track maximum**: Update maximum length whenever a valid window is found
- **Continue**: Repeat until right pointer reaches the end of the string

**Time Complexity**: O(n) - each character is visited at most twice (once by right pointer, once by left pointer)
**Space Complexity**: O(min(n, m)) - where n is string length and m is character set size (typically O(1) for fixed alphabets)

### [Medium] Longest Repeating Character Replacement

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring. Iterate through the string:

- **Initialize frequency map**: Track character counts in the current window
- **Track maximum frequency**: Maintain the count of the most frequent character in the window
- **Expand window**: Move right pointer to include new characters and update frequency count and max frequency
- **Check validity**: Calculate characters needing replacement as (window size - max frequency)
    - If replacements needed ≤ k: window is valid, update maximum length
    - If replacements needed > k: shrink window from left
- **Shrink window**: Remove leftmost character from window, update frequency count, and move left pointer right
- **Continue**: Repeat until right pointer reaches the end of the string

**Time Complexity**: O(n) - single pass through the string with each character processed at most twice
**Space Complexity**: O(1) - fixed-size frequency map (26 characters for uppercase letters) or O(k) for variable character sets

### [Medium] Permutation in String

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring. Iterate through the string:

- **Initialize frequency maps**: Track character counts for the target string (s1) and current window in s2
- **Expand window**: Move right pointer to include new characters and update window frequency count
- **Check match**: When window size equals s1 length, compare frequency counts
    - If frequencies match: return true (permutation found)
    - If frequencies don't match: shrink window from left
- **Shrink window**: Remove leftmost character from window and move left pointer right
- **Continue**: Repeat until right pointer reaches the end of s2

Frequency counts can be compared using arrays of size 26 (for lowercase letters) for efficiency, or hash maps for larger character sets.

**Time Complexity**: O(n) - single pass through s2, where n is the length of s2
**Space Complexity**: O(1) - fixed-size frequency arrays (26 characters) or O(k) for hash maps where k is the character set size

### [Hard] Minimum Window Substring

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring. Iterate through the string:

- **Initialize frequency maps**: Track character counts for the target string and current window
- **Expand window**: Move right pointer to include new characters and update window frequency count
- **Check completeness**: When window contains all required characters (with correct frequencies), attempt to shrink
- **Shrink window**: Move left pointer right while maintaining all required characters, updating minimum window
- **Track minimum**: Record the smallest valid window found

**Time Complexity**: O(m + n) — where m is target length and n is source string length
**Space Complexity**: O(k) — where k is the number of distinct required characters (bounded by the alphabet size)

### [Hard] Sliding Window Maximum

**Main idea**:
Use a deque (double-ended queue) to store indices of array elements. Iterate through the array:

- **Maintain decreasing order**: The deque keeps indices in decreasing order of their corresponding values
- **Remove out-of-window indices**: Remove indices from the front if they fall outside the current window
- **Remove smaller elements**: Remove indices from the back while the current element is greater than elements at those indices
- **Add current index**: Add the current index to the back of the deque
- **Track maximum**: The maximum for the current window is always at the front of the deque

**Time Complexity**: O(n) - each element is added and removed from the deque at most once
**Space Complexity**: O(k) - deque stores at most k indices (window size)

## Stack

### [Easy] Valid Parentheses

**Main idea**:
Use a stack to track opening parentheses. Iterate through each character:

- **Opening bracket** (`'('`, `'{'`, `'['`): Push onto the stack
- **Closing bracket** (`')'`, `'}'`, `']'`):
    - Check if stack is non-empty and top matches the corresponding opening bracket
    - If it matches: pop the stack
    - If it doesn't match or stack is empty: return false

After processing all characters, return true if the stack is empty (all brackets matched), otherwise return false.

**Time Complexity**: O(n) - single pass through the string
**Space Complexity**: O(n) - stack stores at most n/2 opening brackets

### [Medium] Min Stack

**Main idea**:
Use two stacks to track both values and minimum values at each state:

- **Initialize two stacks**: Create a main stack for values and a min stack for tracking minimums
- **Push operation**: When pushing value x:
    - Push x onto main stack
    - If min stack is empty or x ≤ min stack top, push x onto min stack
    - Otherwise, push current minimum (min stack top) onto min stack again
- **Pop operation**:
    - Pop from both main stack and min stack simultaneously
- **Top operation**:
    - Return top element from main stack
- **Get minimum operation**:
    - Return top element from min stack (always contains current minimum)

Alternative approach: Only push to min stack when new minimum is found, but requires careful handling during pop operations to ensure min stack stays
synchronized.

The key insight: By maintaining a parallel min stack that stores the minimum value at each level of the main stack, we can retrieve the minimum in O(1) time.
Each position in the min stack represents the minimum of all elements at or below that position in the main stack.

**Edge cases**: Stack can be empty after series of push/pop operations. Minimum tracking must handle duplicate minimum values correctly.

**Time Complexity**: O(1) - all operations (push, pop, top, getMin) are constant time
**Space Complexity**: O(n) - worst case, min stack stores n elements (same as main stack)

### [Medium] Evaluate Reverse Polish Notation

**Main idea**:
Use a stack to evaluate expressions in Reverse Polish Notation (postfix). Iterate through the tokens:

- **Initialize stack**: Create empty stack to store operands
- **Process each token**: For each token in the expression:
    - **If number**: Push the number onto the stack
    - **If operator** (`'+'`, `'-'`, `'*'`, `'/'`):
        - Pop two operands from stack (second operand popped first, then first operand)
        - Apply the operation: first_operand operator second_operand
        - Push the result back onto the stack
- **Return result**: The final value remaining on the stack is the answer

The key insight: RPN eliminates the need for parentheses and operator precedence rules. The stack naturally handles the order of operations since operators
always apply to the most recent operands.

**Important note**: Order matters when popping - the second value popped is the first operand. For example, with tokens ["4", "13", "5", "/"], we pop 5 first (
second operand), then 13 (first operand), and compute 13 / 5 = 2.

**Edge cases**: Division truncates toward zero. Valid expressions always result in exactly one value on the stack.

**Time Complexity**: O(n) - single pass through all tokens
**Space Complexity**: O(n) - stack stores at most n/2 operands

### [Medium] Generate Parentheses

**Main idea**:
Use backtracking (recursive DFS) to build all valid combinations of parentheses. Track the count of opening and closing parentheses:

- **Initialize result list**: Create empty list to store all valid combinations
- **Recursive backtracking function**: Start with empty string, 0 open parentheses, 0 close parentheses
- **Decision rules at each step**:
    - **Add opening parenthesis**: If open_count < n, add '(' and recurse with open_count + 1
    - **Add closing parenthesis**: If close_count < open_count, add ')' and recurse with close_count + 1
- **Base case**: When open_count == n AND close_count == n:
    - Add the current string to result list
    - Return to explore other combinations
- **Backtrack**: After exploring a path, remove the last added parenthesis and try other options
- **Return result**: List of all valid combinations

The key insight: We can only add a closing parenthesis if we have more opening parentheses than closing ones (close_count < open_count). This ensures validity
at every step. We can add an opening parenthesis as long as we haven't used all n pairs yet (open_count < n).

**Edge cases**: n = 1 returns ["()"], which is the base case. n = 0 would return [""].

**Time Complexity**: O(4^n / √n) - this is the nth Catalan number, representing the count of valid combinations
**Space Complexity**: O(n) - recursion stack depth for building strings of length 2n

### [Medium] Daily Temperatures

**Main idea**:
Use a monotonic decreasing stack to track indices of temperatures waiting for a warmer day. Iterate through the temperatures array:

- **Initialize result array**: Create array of same length, filled with 0s (default: no warmer day)
- **Initialize stack**: Create empty stack to store indices (not temperatures)
- **Process each temperature**: For each index i in temperatures:
    - **Check for warmer days**: While stack is not empty AND current temperature > temperature at stack top:
        - Pop index from stack (let's call it prevIndex)
        - Calculate days to wait: result[prevIndex] = i - prevIndex
        - Continue popping while condition holds
    - **Push current index**: Add current index i to stack
- **Return result**: Remaining indices in stack already have 0 (no warmer day found)

The key insight: The stack maintains indices of temperatures in decreasing order. When we encounter a warmer temperature, it resolves all previous cooler
temperatures still waiting in the stack. This is a **monotonic stack pattern** - we maintain a specific ordering (decreasing temperatures) and process elements
when that order is violated.

**Example walkthrough** for temperatures = [73,74,75,71,69,72,76,73]:

- i=0: Stack=[0], temp=73
- i=1: temp=74 > temp[0]=73, so result[0]=1-0=1, Stack=[1]
- i=2: temp=75 > temp[1]=74, so result[1]=2-1=1, Stack=[2]
- i=3: temp=71 < temp[2]=75, Stack=[2,3]
- i=4: temp=69 < temp[3]=71, Stack=[2,3,4]
- i=5: temp=72 > temp[4]=69, result[4]=5-4=1; temp=72 > temp[3]=71, result[3]=5-3=2; Stack=[2,5]
- i=6: temp=76 > temp[5]=72, result[5]=6-5=1; temp=76 > temp[2]=75, result[2]=6-2=4; Stack=[6]
- i=7: temp=73 < temp[6]=76, Stack=[6,7]
- Result: [1,1,4,2,1,1,0,0]

**Edge cases**: Single temperature returns [0]. All increasing temperatures: each element is 1 except last (0). All decreasing temperatures: all elements are 0.

**Time Complexity**: O(n) - each index is pushed and popped from stack at most once
**Space Complexity**: O(n) - stack stores at most n indices in worst case (decreasing temperatures)

### [Medium] Car Fleet

**Main idea**:
Sort cars by position and calculate arrival times to determine how many fleets form. Use a stack or counter to track fleets:

- **Pair positions with speeds**: Create list of (position, speed) pairs for each car
- **Sort by position**: Sort pairs in descending order (closest to target first)
- **Calculate arrival times**: For each car, compute time = (target - position) / speed
- **Process cars from closest to target**: Iterate through sorted cars:
    - **Calculate arrival time**: time_to_arrive = (target - position) / speed
    - **Check if new fleet forms**:
        - If stack is empty OR current car's time > top of stack time: new fleet forms
        - Push current arrival time onto stack
        - Else: current car catches up to fleet ahead (don't push, it merges)
- **Return fleet count**: Size of stack equals number of fleets

The key insight: A car forms a new fleet only if it takes **longer** to reach the target than the car directly ahead of it. If it arrives sooner, it must slow
down to match the fleet ahead (cars can't pass). By processing from closest to target backwards, we can determine which cars catch up versus which form
independent fleets.

**Example walkthrough** for target=12, position=[10,8,0,5,3], speed=[2,4,1,1,3]:

- Sort by position: [(10,2), (8,4), (5,1), (3,3), (0,1)]
- Arrival times: [1.0, 1.0, 7.0, 3.0, 12.0]
- Process:
    - Car at 10: time=1.0, stack=[1.0], fleets=1
    - Car at 8: time=1.0, same as stack top (merges), stack=[1.0], fleets=1
    - Car at 5: time=7.0 > 1.0 (new fleet), stack=[1.0, 7.0], fleets=2
    - Car at 3: time=3.0 < 7.0 (catches up), stack=[1.0, 7.0], fleets=2
    - Car at 0: time=12.0 > 7.0 (new fleet), stack=[1.0, 7.0, 12.0], fleets=3

**Edge cases**: Single car returns 1. All cars at same position impossible (positions are unique). Cars already at target have time=0.

**Time Complexity**: O(n log n) - dominated by sorting the cars by position
**Space Complexity**: O(n) - storing the sorted pairs and stack of arrival times

### [Hard] Largest Rectangle in Histogram

**Main idea**:
Use a monotonic increasing stack to efficiently find the largest rectangle. For each bar, determine how far left and right it can extend:

- **Initialize variables**: Create empty stack to store indices, and max_area = 0
- **Process each bar**: Iterate through all bars with index i:
    - **Pop taller bars**: While stack is not empty AND current height < height at stack top:
        - Pop index from stack (call it top_index)
        - Calculate height: height = heights[top_index]
        - Calculate width:
            - If stack is empty: width = i (extends to beginning)
            - Else: width = i - stack.peek() - 1
        - Calculate area: area = height × width
        - Update max_area if current area is larger
    - **Push current index**: Add current index i to stack
- **Process remaining bars**: After the loop, pop remaining indices and calculate areas
    - If the stack is empty after popping `top_index`: `width = n`
    - Else: `width = n - stack.peek() - 1`
- **Return `max_area`**: Maximum rectangle area found

The key insight: The stack maintains bars in **increasing height order**. When we encounter a shorter bar, all taller bars in the stack have found their right
boundary (they can't extend past this shorter bar). The bar below each popped bar in the stack represents its left boundary. This allows us to calculate the
maximum rectangle area for each bar as the minimum height in O(n) time.

**Example walkthrough** for heights = [2,1,5,6,2,3]:

- i=0: height=2, stack=[0]
- i=1: height=1 < heights[0]=2, pop 0: area=2×1=2, push 1, stack=[1]
- i=2: height=5, stack=[1,2]
- i=3: height=6, stack=[1,2,3]
- i=4: height=2 < heights[3]=6, pop 3: area=6×1=6, pop 2: area=5×2=10, push 4

## Binary Search

### [Easy] Binary Search

**Main idea**:
Use divide and conquer to efficiently search for a target value in a sorted array by repeatedly halving the search space:

- **Initialize pointers**: Set left pointer at index 0 and right pointer at last index (n-1)
- **Loop until found or exhausted**: While left ≤ right:
    - **Calculate middle index**: mid = left + (right - left) / 2 (avoids integer overflow)
    - **Check middle element**:
        - If nums[mid] == target: return mid (found!)
        - If nums[mid] < target: search right half, set left = mid + 1
        - If nums[mid] > target: search left half, set right = mid - 1
- **Return -1**: If loop ends without finding target, it doesn't exist in array

The key insight: By comparing with the middle element and eliminating half the remaining search space each iteration, we achieve logarithmic time complexity.
This only works on **sorted arrays** - the sorted property guarantees that if the middle element is too large, all elements to the right are also too large (and
vice versa).

**Why use left + (right - left) / 2?**: The formula `(left + right) / 2` can cause integer overflow if left + right exceeds the maximum integer value. Using
`left + (right - left) / 2` is mathematically equivalent but avoids this issue.

**Edge cases**: Empty array returns -1. Single element: either match or -1. Target smaller than all elements or larger than all elements returns -1.

**Time Complexity**: O(log n) - search space halves with each iteration
**Space Complexity**: O(1) - only uses constant extra space for pointers (iterative version)

### [Medium] Search in 2D Matrix

**Main idea**:
Treat the 2D matrix as a virtual 1D sorted array and perform binary search by converting indices between 1D and 2D coordinates:

- **Initialize pointers**: Set left = 0 and right = m × n - 1 (total elements - 1)
- **Binary search loop**: While left ≤ right:
    - **Calculate middle index**: mid = left + (right - left) / 2
    - **Convert to 2D coordinates**:
        - row = mid / n (number of columns)
        - col = mid % n (modulo gives column position)
    - **Compare with target**:
        - If matrix[row][col] == target: return true (found!)
        - If matrix[row][col] < target: search right half, set left = mid + 1
        - If matrix[row][col] > target: search left half, set right = mid - 1
- **Return false**: Target not found in matrix

The key insight: Since each row is sorted and the first element of each row is greater than the last element of the previous row, the entire matrix can be
viewed as a single sorted sequence. By converting between 1D indices (for binary search) and 2D coordinates (for matrix access), we achieve O(log(m×n)) time
complexity without actually flattening the matrix.

**Alternative approach**: Perform two binary searches - first find the correct row, then search within that row.
This also achieves O(log m + log n) = O(log(m×n)) time.

**Edge cases**: Empty matrix returns false. Single element matrix: check if it equals target. Target outside the range [matrix[0][0], matrix[m-1][n-1]] returns
false.

**Time Complexity**: O(log(m × n)) - binary search on m × n elements
**Space Complexity**: O(1) - only using constant space for pointers and coordinate conversion

### [Medium] Koko Eating Bananas

**Main idea**:
Use binary search on the answer space (eating speed) to find the minimum speed that allows finishing all bananas within h hours:

- **Define search space**: Set left = 1 (minimum speed) and right = max(piles) (maximum useful speed)
- **Binary search on speed**: While left < right:
    - **Calculate mid-speed**: mid = left + (right - left) / 2
    - **Check feasibility**: Calculate total hours needed at speed mid:
        - For each pile, hours = ceil(pile / mid) = (pile + mid - 1) / mid
        - Sum all hours for all piles
    - **Adjust search space**:
        - If total_hours ≤ h: speed mid is feasible, try slower speed, set right = mid
        - If total_hours > h: speed too slow, need faster speed, set left = mid + 1
- **Return left**: Minimum speed that allows finishing within h hours

The key insight: This is a **binary search on answer** problem with a monotonic property - if Koko can finish all bananas at speed k within h hours, she can
definitely finish at any speed faster than k. The problem becomes finding the minimum feasible speed. We don't search for the answer in the array; instead, we
search the range of possible speeds [1, max(piles)].

**Why max(piles) as upper bound?**: Koko can only eat from one pile per hour, so eating faster than the largest pile provides no benefit - she'd still spend one
hour per pile regardless.

**Edge cases**: Single pile: return ceil(pile/h). If h equals number of piles, return max(piles).

**Time Complexity**: O(n × log m) - where n is number of piles and m is max(piles), binary search runs log m iterations, each checking all n piles
**Space Complexity**: O(1) - only using constant space for variables

### [Medium] Find Minimum in Rotated Sorted Array

**Main idea**:
Use modified binary search to find the minimum element by identifying which half is sorted and eliminating the sorted half:

- **Initialize pointers**: Set left = 0 and right = n - 1
- **Binary search loop**: While left < right:
    - **Calculate middle index**: mid = left + (right - left) / 2
    - **Check if already sorted**: If nums[left] < nums[right], array is sorted, return nums[left]
    - **Determine which half contains minimum**:
        - If nums[mid] > nums[right]: minimum is in right half (rotation point is to the right)
            - Set left = mid + 1
        - Else: minimum is in left half (including mid, as mid could be the minimum)
            - Set right = mid
- **Return nums[left]**: Left pointer points to minimum element

The key insight: In a rotated sorted array, comparing the middle element with the rightmost element tells us which half is sorted and which contains the
rotation point (where the minimum lives). If nums[mid] > nums[right], the right half is unsorted and contains the minimum. Otherwise, the left half (including
mid) contains the minimum. We never eliminate mid when it could be the minimum, which is why we use `right = mid` instead of `right = mid - 1`.

**Why compare with right instead of left?**: Comparing with nums[right] gives clearer logic - if mid > right, we know for certain the minimum is to the right of
mid. If we compared with left, the logic becomes more complex with edge cases.

**Example walkthrough** for nums = [4,5,6,7,0,1,2]:

- left=0, right=6, mid=3: nums[3]=7 > nums[6]=2 → minimum in right half, left=4
- left=4, right=6, mid=5: nums[5]=1 < nums[6]=2 → minimum in left half (including mid), right=5
- left=4, right=5, mid=4: nums[4]=0 < nums[5]=1 → minimum in left half, right=4
- left=4, right=4 → loop ends, return nums[4]=0

**Edge cases**: Array not rotated (already sorted) returns first element. Single element returns that element.

**Time Complexity**: O(log n) - binary search eliminates half the search space each iteration
**Space Complexity**: O(1) - only using constant space for pointers

### [Medium] Search in Rotated Sorted Array

**Main idea**:  
Use binary search while exploiting that at least one half of a rotated sorted array (with distinct elements) is always sorted; decide which half is sorted using
nums[left] and nums[mid], then narrow the search to the half that can contain the target.

- **Initialize pointers**: Set left = 0 and right = n - 1
- **Binary search loop**: While left <= right, compute mid = left + (right - left) / 2
- **Hit check**: If nums[mid] == target, return mid
- **Find sorted half**: If nums[left] <= nums[mid], the left half [left..mid] is sorted; otherwise the right half [mid..right] is sorted
- **Target in left half?** If left half is sorted and nums[left] <= target < nums[mid], move right = mid - 1; otherwise move left = mid + 1
- **Target in right half?** If right half is sorted and nums[mid] < target <= nums[right], move left = mid + 1; otherwise move right = mid - 1
- **Miss**: If the loop ends without a match, return -1

**The key insight**:  
In a rotated sorted array with distinct elements, one side of mid is always sorted; comparing nums[left] and nums[mid] tells which side is sorted, and a simple
range check on that side's endpoints determines whether to keep it or discard it, ensuring a logarithmic search space reduction each iteration.

**Why compare with left?**  
Checking nums[left] <= nums[mid] directly answers whether the left portion is monotonically increasing, which makes range tests against [nums[left], nums[mid])
straightforward; comparing with right also works, but left-based checks often lead to slightly clearer and symmetric conditions in code for this problem
variant.

**Example walkthrough** for nums = [4,5,6,7,0,1,2], target = 0:

- left=0, right=6, mid=3: nums[left]=4 <= nums[mid]=7 → left half sorted; 4 <= 0 < 7 is false → left = mid + 1 = 4
- left=4, right=6, mid=5: nums[left]=0 <= nums[mid]=1 → left half sorted; 0 <= 0 < 1 is true → right = mid - 1 = 4
- left=4, right=4: nums[mid]=nums[4]=0 equals target → return 4

**Edge cases**:

- Not rotated (nums[left] <= nums[right]) still works because one side remains sorted at each step and the range checks behave like standard binary search
- Single-element arrays return either index 0 if it matches target or -1 otherwise, handled naturally by the loop condition
- Target absent concludes with left > right and returns -1 by construction

**Time Complexity**: O(log n) — each iteration halves the search interval by discarding one side  
**Space Complexity**: O(1) — only constant extra variables for indices and comparisons are used

### [Medium] Time Based Key-Value Store

**Main idea**:  
Use a hashmap from key to a timestamp-sorted list of (timestamp, value) pairs; on set, append because timestamps per key are strictly increasing, and on get,
binary search to find the value with the largest timestamp ≤ t in O(log m), where m is the number of versions for that key.

- **Data structure**: Map<String, List<(timestamp, value)>> with each per-key list maintained in increasing timestamp order due to strictly increasing set
  timestamps.
- **set(key, value, t)**: Append (t, value) to the list for that key; this preserves order and yields amortized \(O(1)\) insertion without
  re-sorting.
- **get(key, t)**: If the key is absent, return ""; otherwise binary search the key’s list for the rightmost timestamp ≤ t and return its value, or "" if no
  such timestamp exists.
- **Key insight**: Appending preserves per-key sorted order, enabling a rightmost-≤ lookup via binary search without extra maintenance work.

**Why binary search?**  
Timestamps per key are monotonic, so a rightmost-≤ search returns the most recent valid value in \(O(\log m)\) time instead of scanning
linearly.

**Example walkthrough**:  
After set("foo","bar",1) and set("foo","bar2",4), get("foo",3) returns "bar", and get("foo",5) returns "bar2" because 1 ≤ 3 < 4 and 4 ≤ 5
respectively.

**Edge cases**:

- Missing key: return "" immediately since no versions exist for that key.
- Query time before the key’s first timestamp: return "" as no timestamp ≤ t exists.
- Exact timestamp match: return that exact value when found by the binary search.

**Time Complexity**: set in amortized \(O(1)\); get in \(O(\log m)\) per query over the versions of that key.
**Space Complexity**: \(O(N)\) total across all keys, where \(N\) is the number of set operations.

### [Hard] Median of Two Sorted Arrays

**Main idea**:  
Use binary search on the partition index of the smaller array to split both arrays into left and right halves such that every element on the left is ≤ every
element on the right; the median is then determined from the boundary elements in O(log min(m,n)) time.

- **Ensure A is smaller**: Swap arrays if needed so that binary search operates on the smaller array
- **Initialize binary search**: Set low = 0 and high = length of A
- **Binary search loop**: While low <= high:
    - **Calculate partition positions**:
        - cutX = (low + high) / 2
        - cutY = ⌊(m + n + 1) / 2⌋ - cutX
    - **Define boundary elements**:
        - leftX = A[cutX-1] if cutX > 0, else -∞
        - rightX = A[cutX] if cutX < |A|, else +∞
        - leftY = B[cutY-1] if cutY > 0, else -∞
        - rightY = B[cutY] if cutY < |B|, else +∞
    - **Check partition validity**: If leftX ≤ rightY AND leftY ≤ rightX:
        - If (m + n) is odd: return max(leftX, leftY)
        - If (m + n) is even: return (max(leftX, leftY) + min(rightX, rightY)) / 2
    - **Adjust search space**:
        - If leftX > rightY: high = cutX - 1 (move left in A)
        - Else: low = cutX + 1 (move right in A)

**The key insight**:  
The correct partition divides the combined arrays into two halves of equal size (or differing by 1) where all left elements are ≤ all right elements. Binary
searching the partition position in the smaller array determines both partitions simultaneously, making this efficient. The median lies exactly at the partition
boundary.

**Why binary search on the smaller array?**  
Searching on the smaller array minimizes iterations to O(log min(m,n)) and ensures the corresponding partition in the larger array remains valid (cutY stays
within bounds).

**Example walkthrough** for nums1 = [1,3], nums2 = [2]:

- m=2, n=1, total=3 (odd), need left half size = 2
- cutX=1 (middle of A), cutY=1 (from formula: ⌊(2+1+1)/2⌋ - 1 = 1)
- leftX=1, rightX=3, leftY=2, rightY=+∞
- Check: 1 ≤ +∞ ✓ and 2 ≤ 3 ✓ → partition valid
- Odd total → median = max(1, 2) = 2

**Edge cases**:

- One empty array: Binary search handles via -∞/+∞ sentinels; reduces to finding middle of non-empty array
- All elements in A less than all in B: Partition at end of A naturally satisfies conditions
- Duplicate values: Order and boundary checks work regardless of duplicates

**Time Complexity**: O(log min(m, n)) — binary search on smaller array  
**Space Complexity**: O(1) — only constant variables for pointers and boundaries

## Linked List

### [Easy] Reverse Linked List

**Main idea**:  
Iterate once with three pointers (`prev`, `curr`, `next`): save `next`, set `curr.next = prev`, then advance `prev = curr` and `curr = next`; when `curr`
becomes `null`, `prev` is the new head, producing an in-place reversal in O(n) time.

- **Initialize pointers**: Set `prev = null` and `curr = head`
- **Iterative loop**: While `curr != null`:
    - **Save next node**: `next = curr.next`
    - **Reverse link**: `curr.next = prev`
    - **Advance pointers**: `prev = curr`, `curr = next`
- **Return result**: When the loop ends (`curr == null`), return `prev` as the new head

**The key insight**:  
Saving `next` before flipping `curr.next` preserves reachability to the remainder of the list, allowing safe, local pointer reversal per node in a single pass.

**Why three-pointers?**  
The `prev`–`curr`–`next` pattern achieves linear time and constant extra space iteratively, avoiding the call\-stack overhead and potential stack overflow of
recursion.

**Example walkthrough** for `head = 1 -> 2 -> 3 -> null`:

- Start: `prev = null`, `curr = 1`
- Step 1: save `2`; set `1.next = null`; move `prev = 1`, `curr = 2`
- Step 2: save `3`; set `2.next = 1`; move `prev = 2`, `curr = 3`
- Step 3: save `null`; set `3.next = 2`; move `prev = 3`, `curr = null`
- Return `prev = 3` → `3 -> 2 -> 1 -> null`

**Edge cases**:

- Empty list (`head = null`): Loop never runs; return `null`
- Single node: One flip sets its `next` to `null`; same node becomes new head
- Two nodes: Two flips produce `B -> A -> null` from `A -> B -> null`

**Time Complexity**: O(n) — each node is visited and relinked once  
**Space Complexity**: O(1) — only three pointer variables are used

### [Easy] Merge Two Sorted Lists

**Main idea**:
Use a **dummy (sentinel) head** and a **tail** pointer. Compare the heads of both sorted lists, splice the smaller node to `tail.next`, advance that list’s
pointer, and move `tail` forward. When one list ends, append the remainder of the other. Return `dummy.next`. Runs in **O(m+n)** time, **O(1)** extra space, and
is **stable** if ties pick from the first list.

* **Initialize pointers**:
  Create `dummy`, set `tail = dummy`; let `p = head1`, `q = head2`.
* **Iterative loop**: While `p != null` and `q != null`:

    * If `p.val <= q.val`: set `tail.next = p`; advance `p = p.next`
    * Else: set `tail.next = q`; advance `q = q.next`
    * Advance `tail = tail.next`
* **Attach remainder**:
  `tail.next = (p != null ? p : q)`
* **Return result**:
  `return dummy.next`

**The key insight**:
The sentinel `dummy` removes head special-casing; maintaining the invariant that `dummy.next … tail` is sorted ensures global correctness.

**Time Complexity**: O(m+n)
**Space Complexity**: O(1)

### [Medium] Reorder List

**Main idea**:
Transform the list in-place using **Split → Reverse → Weave**:

* **Find middle**: Use slow/fast pointers to locate the end of the first half (slow stops at mid-left for even length)
* **Split**: Detach halves by setting `slow.next = null`
* **Reverse second half**: Reverse the list starting at the original `slow.next`
* **Weave halves**: Alternately splice nodes: take one from the first half, then one from the reversed second half, repeating until the second half is exhausted

The key insight:
Reversing the second half turns the desired order `L0, Ln, L1, Ln-1, …` into a simple alternating merge of two lists.

**Edge cases**:
Empty list, single node, or two nodes require no changes. For odd lengths, the first half will have one extra node and remains at the end after weaving.

**Time Complexity**: O(n) — one pass to find middle, one to reverse, one to weave
**Space Complexity**: O(1) — in-place with a constant number of pointers

### [Medium] Remove Nth Node From End of List

**Main idea**:
Use a **dummy head** and two pointers to keep a fixed gap of **n** nodes, so the **slow** pointer lands just **before** the node to remove.

* **Create dummy**: Set `dummy.next = head`. Initialize `slow = dummy`, `fast = dummy`.
* **Offset fast**: Advance `fast` **n+1** steps to create a gap of `n` between `slow` and the target node (so `slow` ends up before it).
* **Traverse together**: While `fast != null`, advance both `fast` and `slow` by one.
* **Delete node**: Relink `slow.next = slow.next.next`.
* **Return result**: `return dummy.next`.

The key insight:
By maintaining a fixed gap, when `fast` reaches the end, `slow` is positioned exactly one node before the one to delete, enabling O(1) removal without computing
the length.

**Edge cases**:
Removing the head (`n == length`) is handled naturally by the dummy node; empty or single-node lists work without special cases. If `n` exceeds the list length,
behavior depends on your contract (common approach: no-op / return original head).

**Time Complexity**: O(n) — one pass after the initial offset
**Space Complexity**: O(1) — constant extra pointers

## Trees

TODO

## Heaps & Priority Queue

TODO

## Backtracking

TODO

## Tries

TODO

## Graphs

TODO

## Advanced Graphs

TODO

## 1-D Dynamic Programming

TODO

## 2-D Dynamic Programming

TODO

## Greedy

TODO

## Intervals

TODO

## Math & Geometry

TODO

## Bit Manipulation

TODO