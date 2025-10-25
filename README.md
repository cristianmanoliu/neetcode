# NeetCode-150

https://neetcode.io/practice?tab=neetcode150

## Arrays & Hashing

### [Easy] Contains Duplicate

**Main idea**:
Use a hash set to track seen elements as you iterate through the array:

- **Initialize hash set**: Create an empty set to store seen elements
- **Iterate through array**: For each element in the array:
    - **Check for duplicate**: If current element exists in the set, return true
    - **Add to set**: Otherwise, add current element to the set
- **Return false**: If iteration completes without finding duplicates

The key insight: A hash set provides O(1) average-case lookup and insertion, allowing us to detect duplicates in a single pass.

**Edge cases**: Empty array or single element array returns false.

**Time Complexity**: O(n) - single pass through the array
**Space Complexity**: O(n) - hash set stores up to n elements

### [Easy] Valid Anagram

**Main idea**:
Use a hash map to count character frequencies and compare between two strings:

- **Early check**: If string lengths differ, return false immediately
- **Count frequencies**: Create hash map counting frequency of each character in first string
- **Verify second string**: Iterate through second string:
    - Decrement count for each character in the map
    - If character not found or count goes below zero, return false
- **Verify completion**: Check if all counts are zero (or simply verify second string depleted the counts)

Alternative approach: Use an array of size 26 for lowercase letters instead of hash map for better space efficiency.

The key insight: Two strings are anagrams if and only if they have identical character frequency distributions.

**Edge cases**: Empty strings are anagrams of each other. Case sensitivity matters unless specified otherwise.

**Time Complexity**: O(n) - where n is the length of the strings
**Space Complexity**: O(1) - fixed size (26 characters) or O(k) where k is character set size

### [Easy] Two Sum

**Main idea**:
Use a hash map to store complements and find the pair in a single pass:

- **Initialize hash map**: Create empty map to store {number: index} pairs
- **Iterate through array**: For each element at index i:
    - **Calculate complement**: target - nums[i]
    - **Check for complement**: If complement exists in map, return [map[complement], i]
    - **Store current**: Add nums[i] and its index to the map
- **Continue**: Repeat until pair is found

The key insight: By storing each number's complement (target - number) as we iterate, we can find the pair in O(n) time instead of O(n²) with nested loops.

**Edge cases**: Problem guarantees exactly one solution exists. Array has at least 2 elements.

**Time Complexity**: O(n) - single pass through the array
**Space Complexity**: O(n) - hash map stores up to n elements

### [Medium] Group Anagrams

**Main idea**:
Use a hash map with sorted strings (or character counts) as keys to group anagrams:

- **Initialize hash map**: Create map where keys represent anagram patterns and values are lists of strings
- **Iterate through strings**: For each string:
    - **Generate key**: Sort the string to create a canonical representation (or use character count array)
    - **Group by key**: Append the original string to the list at that key
- **Return groups**: Extract all values from the map as the result

Alternative key generation: Use character frequency array of size 26, convert to tuple for hashing (more efficient than sorting).

The key insight: All anagrams share the same sorted representation or character frequency distribution, making them perfect hash keys.

**Edge cases**: Empty string list returns empty result. Single character strings group individually.

**Time Complexity**: O(n × k log k) - where n is number of strings and k is max string length (for sorting); O(n × k) with frequency counting
**Space Complexity**: O(n × k) - storing all strings in the hash map

### [Medium] Top K Frequent Elements

**Main idea**:
Use a hash map to count frequencies, then a heap to find the top k elements:

- **Count frequencies**: Create hash map tracking frequency of each element
- **Initialize min-heap**: Create heap of size k to track top k frequent elements
- **Process frequencies**: For each unique element and its frequency:
    - **Add to heap**: Push (frequency, element) onto heap
    - **Maintain size**: If heap size exceeds k, remove minimum element
- **Extract result**: Pop all elements from heap to get top k frequent elements

Alternative: Use bucket sort with array of size n+1 where index represents frequency (O(n) time).

The key insight: A min-heap of size k efficiently maintains the k largest frequencies while processing all elements in O(n log k) time.

**Edge cases**: If k equals array length, return all unique elements. Array must have at least k unique elements.

**Time Complexity**: O(n log k) - n elements processed with heap operations of O(log k)
**Space Complexity**: O(n) - hash map stores all unique elements

### [Medium] Encode and Decode Strings

**Main idea**:
Use length-prefix encoding to handle strings with any characters including delimiters:

- **Encode**: For each string, prepend its length followed by a delimiter (e.g., "4#word5#hello")
    - Concatenate: length + "#" + string for each string
    - This handles strings containing any characters since length is explicit
- **Decode**: Parse the encoded string:
    - Read length until delimiter "#"
    - Extract exactly that many characters as the string
    - Repeat until end of encoded string

The key insight: Length-prefix encoding avoids delimiter collision issues since we know exactly how many characters to read for each string.

**Edge cases**: Empty strings encoded as "0#". Empty list encodes to empty string.

**Time Complexity**: O(n) - where n is total characters across all strings
**Space Complexity**: O(n) - for storing the encoded/decoded result

### [Medium] Product of Array Except Self

**Main idea**:
Use two passes to calculate products without division:

- **Initialize output array**: Create result array of same length, initialized to 1
- **Left pass**: Traverse left to right:
    - For each index i, set output[i] = product of all elements to the left
    - Maintain running product: left_product *= nums[i-1]
- **Right pass**: Traverse right to left:
    - For each index i, multiply output[i] by product of all elements to the right
    - Maintain running product: right_product *= nums[i+1]
- **Return result**: Output array now contains product of array except self

The key insight: By separating left and right products into two passes, we avoid division and handle zeros correctly while maintaining O(1) extra space.

**Edge cases**: Array length is at least 2. Zeros in array are handled correctly without division.

**Time Complexity**: O(n) - two passes through the array
**Space Complexity**: O(1) - output array doesn't count as extra space per problem constraints

### [Medium] Valid Sudoku

**Main idea**:
Use hash sets to track numbers seen in rows, columns, and 3×3 sub-boxes:

- **Initialize tracking structures**: Create three collections of sets:
    - rows: array of 9 sets (one per row)
    - cols: array of 9 sets (one per column)
    - boxes: array of 9 sets (one per 3×3 sub-box)
- **Iterate through board**: For each cell (row, col):
    - Skip empty cells ('.')
    - **Calculate box index**: box_index = (row // 3) × 3 + (col // 3)
    - **Check for duplicate**: If number exists in rows[row], cols[col], or boxes[box_index], return false
    - **Add to sets**: Add number to respective row, column, and box sets
- **Return true**: If no duplicates found

The key insight: Using separate hash sets for rows, columns, and boxes allows O(1) duplicate checking in a single pass through the board.

**Edge cases**: Board is always 9×9. Empty cells marked with '.'. Only need to validate filled cells.

**Time Complexity**: O(1) - always checking 81 cells regardless of input
**Space Complexity**: O(1) - fixed space for 27 sets (9 rows + 9 cols + 9 boxes)

### [Medium] Longest Consecutive Sequence

**Main idea**:
Use a hash set to identify sequence starts and count lengths efficiently:

- **Initialize hash set**: Add all array elements to set for O(1) lookup
- **Initialize max length**: Track longest sequence found (start at 0)
- **Iterate through array**: For each number:
    - **Check if sequence start**: If (num - 1) not in set, this is a sequence start
    - **Count sequence length**: Starting from num, increment and check set membership:
        - While (num + length) exists in set, increment length
    - **Update maximum**: If current sequence longer than max, update max
- **Return result**: Maximum sequence length found

The key insight: By only counting from sequence starts (where num-1 doesn't exist), we avoid redundant work and achieve O(n) time despite nested loops.

**Edge cases**: Empty array returns 0. Single element returns 1. Duplicates don't affect result.

**Time Complexity**: O(n) - each number visited at most twice (once in outer loop, once when counting)
**Space Complexity**: O(n) - hash set stores all unique elements

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

**Time Complexity**: O(m + n) - where m is target length and n is source string length
**Space Complexity**: O(m + n) - for frequency maps of both strings

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

## Binary Search

## Linked List

## Trees

## Heaps & Priority Queue

## Backtracking

## Tries

## Graphs

## Advanced Graphs

## 1-D Dynamic Programming

## 2-D Dynamic Programming

## Greedy

## Intervals

## Math & Geometry

## Bit Manipulation
