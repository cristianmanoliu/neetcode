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

#### Key takeaway

Scan once using a hash set: for each `x`, if `x` is already in the set return `true`; otherwise add it; if the loop ends, return `false`.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

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

#### Key takeaway

If lengths match, count chars from `s` and decrement with `t`; if any decrement goes negative or a char is missing, return false; else true (use int[26] for
lowercase).

**Time:** O(n)
**Space:** O(1) with fixed alphabet (otherwise O(k)).

#### Algorithm explanation

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

### (Easy) Two Sum

#### Key takeaway

Single-pass scan with a hash map `{value → index}`: for each `x` at `i`, if `target - x` is in the map return `[map[target - x], i]`, else store `map[x] = i`.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

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

### (Medium) Group Anagrams

#### Key takeaway

Group strings in a hash map keyed by their canonical form—either `sorted(s)` or a 26-length count tuple—and return the map’s values.

**Time:** O(n·k log k) with sorting, O(n·k) with counts
**Space:** O(n·k)

#### Algorithm explanation

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

### (Medium) Top K Frequent Elements

#### Key takeaway

Count frequencies with a hash map, stream `(freq, val)` into a size-`k` min-heap (evict smallest when >k), then read heap contents as the top-k.

**Time:** O(n log k)
**Space:** O(n)

#### Algorithm explanation

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

### (Medium) Encode and Decode Strings

#### Key takeaway

Encode by concatenating `len(s) + '#' + s` for each string; decode by scanning numbers up to `'#'` to get `len`, then slicing the next `len`
chars, repeating to the end.

**Time:** O(n) over total characters
**Space:** O(n) for encoded/decoded output.

#### Algorithm explanation

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

### (Medium) Product of Array Except Self

#### Key takeaway

Fill `out[i]` with prefix products in a left-to-right pass, then traverse right-to-left keeping a running suffix product and multiply into `out[i]` to get
product-except-self.

**Time:** O(n)
**Space:** O(1) extra (excluding output).

#### Algorithm explanation

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

### (Medium) Valid Sudoku

#### Key takeaway

Scan all 81 cells; for each digit at (r,c), compute `b = (r//3)*3 + (c//3)` and check/insert into `rows[r]`, `cols[c]`, and `boxes[b]`; if any
already contains it, return `false`, else continue and return `true`.

**Time:** O(1) (81 cells)
**Space:** O(1) (fixed sets)

#### Algorithm explanation

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

### (Medium) Longest Consecutive Sequence

#### Key takeaway

Put all numbers in a set; for each `x` where `x-1` isn’t in the set, walk forward `x, x+1, …` counting length and update a running maximum.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

Use a hash set to identify sequence starts and count lengths efficiently:

- **Initialize hash set**: Add all array elements to set for O(1) lookup
- **Initialize max length**: Track the longest sequence found (start at 0)
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

### (Easy) Valid Palindrome

#### Key takeaway

Use two pointers `l,r`; while `l<r`, advance past non-alphanumerics on each side, compare `lower(s[l])` vs `lower(s[r])`; if unequal return `false`, else move
inward; finish → `true`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Two Sum II - Input Array Is Sorted

#### Key takeaway

Use two pointers `l=0, r=n-1`; while `l<r`, compare `sum = a[l]+a[r]`: if `sum==target` return `[l+1, r+1]`; if `sum<target` increment `l`; else decrement `r`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) 3Sum

#### Key takeaway

Sort the array; for each index `i` (skipping duplicates), run a two-pointer scan on `(i+1 … n-1)` to find pairs summing to `-nums[i]`, collecting triplets and
skipping duplicate `left/right` values.

**Time:** O(n²) (dominated by the outer loop × two-pointer)
**Space:** O(1) extra (or O(n) depending on sort).

#### Algorithm explanation

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

### (Medium) Container With Most Water

#### Key takeaway

Two pointers `l=0, r=n-1`; at each step update `max = max(max, min(h[l],h[r])*(r-l))` and move inward the pointer at the shorter height, until `l==r`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Hard) Trapping Rain Water

#### Key takeaway

Two pointers with running maxima: keep `l,r` and `leftMax,rightMax`; at each step, move the side with the smaller height, add `(leftMax - h[l])` or
`(rightMax - h[r])` if positive, updating the respective max, until `l==r`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Easy) Best Time to Buy and Sell Stock

#### Key takeaway

Scan prices once, tracking `minSoFar`; at each price compute `profit = price - minSoFar`, update `maxProfit`, and update `minSoFar` when you see a new low.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

Use a single pass through the array to track the minimum price seen so far and calculate the maximum profit at each step. Iterate through the prices:

- **Initialize variables**: Set minimum price to infinity (or first price) and maximum profit to 0
- **Expand iteration**: Move through each price in the array
- **Calculate potential profit**: For current price, compute profit as (current price - minimum price)
- **Update maximum**: If current profit exceeds maximum profit, update maximum profit
- **Update minimum**: If current price is lower than minimum price, update minimum price
- **Continue**: Repeat until all prices are processed

**Time Complexity**: O(n) - single pass through the array
**Space Complexity**: O(1) - only constant extra space for tracking minimum price and maximum profit

### (Medium) Longest Substring Without Repeating Characters

#### Key takeaway

Slide a window with pointers `l` and `r`, keeping a map `last[c] → last index`; for each `s[r]`, set `l = max(l, last[s[r]]+1)` if seen, update
`last[s[r]] = r`, and track `maxLen = max(maxLen, r-l+1)`.

**Time:** O(n)
**Space:** O(min(n, m)) (m = alphabet size).

#### Algorithm explanation

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

### (Medium) Longest Repeating Character Replacement

#### Key takeaway

Slide a window, update count of `s[r]` and `maxCount`; while `(r-l+1) - maxCount > k`, decrement count of `s[l]` and advance `l`; track
`best = max(best, r-l+1)`.

**Time:** O(n)
**Space:** O(1) for fixed alphabet (else O(m)).

#### Algorithm explanation

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

### (Medium) Permutation in String

#### Key takeaway

If `|s1| > |s2|` return `false`; build 26-counts for `s1`, slide a window of length `|s1|` over `s2` updating counts (increment enter, decrement
exit); if any window’s counts equal `s1`’s counts return `true`, else `false`.

**Time:** O(n) over `s2` (O(1) per step with 26 buckets)
**Space:** O(1) for fixed lowercase alphabet (else O(k) for alphabet size `k`)

#### Algorithm explanation

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

### (Hard) Minimum Window Substring

#### Key takeaway

Slide `r` over `s`, updating window counts and a `formed` tally; whenever `formed == required`, shrink from `l` while valid to minimize and record the best
window, then continue until `r` ends and return the smallest found (or `""`).

**Time:** O(m + n)
**Space:** O(k) (distinct chars in `t`).

#### Algorithm explanation

Use a sliding window approach with two pointers (left and right) to represent the current substring. Iterate through the string:

- **Initialize frequency maps**: Track character counts for the target string and current window
- **Expand window**: Move right pointer to include new characters and update window frequency count
- **Check completeness**: When window contains all required characters (with correct frequencies), attempt to shrink
- **Shrink window**: Move left pointer right while maintaining all required characters, updating minimum window
- **Track minimum**: Record the smallest valid window found

**Time Complexity**: O(m + n) — where m is target length and n is source string length
**Space Complexity**: O(k) — where k is the number of distinct required characters (bounded by the alphabet size)

### (Hard) Sliding Window Maximum

#### Key takeaway

Maintain a deque of indices with decreasing `nums` values: for each `i`, pop front if `i - deque[0] == k`, pop back while `nums[i] ≥ nums[deque[-1]]`, push `i`,
and when `i ≥ k-1` append `nums[deque[0]]` to the output.

**Time:** O(n)
**Space:** O(k)

#### Algorithm explanation

Use a deque (double-ended queue) to store indices of array elements. Iterate through the array:

- **Maintain decreasing order**: The deque keeps indices in decreasing order of their corresponding values
- **Remove out-of-window indices**: Remove indices from the front if they fall outside the current window
- **Remove smaller elements**: Remove indices from the back while the current element is greater than elements at those indices
- **Add current index**: Add the current index to the back of the deque
- **Track maximum**: The maximum for the current window is always at the front of the deque

**Time Complexity**: O(n) - each element is added and removed from the deque at most once
**Space Complexity**: O(k) - deque stores at most k indices (window size)

## Stack

### (Easy) Valid Parentheses

#### Key takeaway

Scan characters with a stack: push opens; on a close `c`, if stack empty or `match[c] != stack.pop()` return `false`; after the scan return `stack.isEmpty()`.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

Use a stack to track opening parentheses. Iterate through each character:

- **Opening bracket** (`'('`, `'{'`, `'['`): Push onto the stack
- **Closing bracket** (`')'`, `'}'`, `']'`):
    - Check if stack is non-empty and top matches the corresponding opening bracket
    - If it matches: pop the stack
    - If it doesn't match or stack is empty: return false

After processing all characters, return true if the stack is empty (all brackets matched), otherwise return false.

**Time Complexity**: O(n) - single pass through the string
**Space Complexity**: O(n) - stack stores at most n/2 opening brackets

### (Medium) Min Stack

#### Key takeaway

For each `push(x)` push to main stack and also push `min(x, minStack.top())` (or `x` if empty); `pop()` pops both stacks; `top()` returns main.top(); `getMin()`
returns minStack.top().

**Time:** O(1) for all operations
**Space:** O(n) (parallel min stack)

#### Algorithm explanation

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

### (Medium) Evaluate Reverse Polish Notation

#### Key takeaway

Scan tokens with a stack; push numbers, and on an operator pop `b` then `a`, compute `a op b` (with division truncating toward zero), push the result; return
the lone stack value.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

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

### (Medium) Generate Parentheses

#### Key takeaway

Backtrack building the string: add `'('` if `open < n`, add `')'` if `close < open`, and when `open == close == n` append to results.

**Time:** O(4^n/√n) (≈ Catalan count; equivalently O(Cₙ·n) including output length)
**Space:** O(n) recursion stack (excluding output)

#### Algorithm explanation

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

### (Medium) Daily Temperatures

#### Key takeaway

Maintain a decreasing stack of indices; for each `i`, while `T[i] > T[stack.top]` pop `j` and set `ans[j] = i - j`, then push `i`; return `ans`.

**Time:** O(n)
**Space:** O(n)

#### Algorithm explanation

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

### (Medium) Car Fleet

#### Key takeaway

Sort cars by position descending; scan from closest to target, compute `t=(target−pos)/speed` for each, and if `t` exceeds the last recorded fleet time start a
new fleet and set `last=t` (else it merges).

**Time:** O(n log n) (sorting dominates)
**Space:** O(n) for pairs/stack (can be O(1) extra with in-place sort + counter)

#### Algorithm explanation

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

### (Hard) Largest Rectangle in Histogram

#### Key takeaway

Append a sentinel 0 height and scan indices with a stack of increasing-height indices; for each `i`, while `heights[i] < heights[stack.top]`, pop `j`, set
`h = heights[j]`, `left = stack.top` (or `-1` if empty), `width = i - left - 1`, update `max = max(max, h*width)`; then push `i`, and at the end return `max`.

**Time:** O(n)
**Space:** O(n) (stack)

#### Algorithm explanation

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

### (Easy) Binary Search

#### Key takeaway

While `l ≤ r`, set `m = l + (r-l)//2`; if `nums[m] == target` return `m`, else if `nums[m] < target` set `l = m+1`, else set `r = m-1`; if loop ends return
`-1`.

**Time:** O(log n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Search in 2D Matrix

#### Key takeaway

Treat matrix as a flat sorted array: binary search `l=0..m·n−1`, with `mid = l + (r−l)//2`, map to `row = mid // n`, `col = mid % n`; compare `matrix[row][col]`
to `target` to move `l/r`, returning `true` if equal, else `false` at end.

**Time:** O(log(m·n))
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Koko Eating Bananas

#### Key takeaway

Binary search eating speed `k` in `[1, max(piles)]`; for each mid, compute `hours = Σ ((pile + mid − 1) // mid)`; if `hours ≤ h` set `right = mid`, else
`left = mid + 1`; return `left`.

**Time:** O(n · log max(piles))
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Find Minimum in Rotated Sorted Array

#### Key takeaway

While `l < r`, if `nums[l] < nums[r]` return `nums[l]`; set `m = l + (r-l)//2`; if `nums[m] > nums[r]` set `l = m+1` else `r = m`; finally return `nums[l]`.

**Time:** O(log n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Search in Rotated Sorted Array

#### Key takeaway

While `l ≤ r`, set `m = l + (r−l)//2`; if `nums[m] == target` return `m`; if `nums[l] ≤ nums[m]` (left sorted) and `nums[l] ≤ target < nums[m]` set `r = m−1`
else `l = m+1`; otherwise (right sorted) if `nums[m] < target ≤ nums[r]` set `l = m+1` else `r = m−1`; if loop ends return `-1`.

**Time:** O(log n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Time Based Key-Value Store

#### Key takeaway

Keep `map: key → [(t, val)]` in increasing `t`; `set` appends `(t,val)`, `get` binary-searches the key’s list for the rightmost `t ≤ query` and returns its
value (or `""` if none).

**Time:** `set` amortized O(1); `get` O(log m) per key (m = versions for that key)
**Space:** O(N) total over all sets

#### Algorithm explanation

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

### (Hard) Median of Two Sorted Arrays

#### Key takeaway

Binary search the cut in the smaller array to find partitions `cutX, cutY` with `leftX ≤ rightY` and `leftY ≤ rightX`; when satisfied, return `max(leftX,leftY)`
if total is odd, else `(max(leftX,leftY)+min(rightX,rightY))/2`, using −∞/+∞ sentinels at boundaries.

**Time:** O(log min(m, n))
**Space:** O(1)

#### Algorithm explanation

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

### (Easy) Reverse Linked List

#### Key takeaway

Iterate with `prev=null, curr=head`; while `curr`, set `next=curr.next`, `curr.next=prev`, advance `prev=curr`, `curr=next`; return `prev`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Easy) Merge Two Sorted Lists

#### Key takeaway

Use a dummy head and `tail`; while `p` and `q`, splice the smaller (`p.val ≤ q.val ? p : q`) to `tail.next` and advance pointers; when one ends, append the
remainder; return `dummy.next`.

**Time:** O(m+n)
**Space:** O(1)

#### Algorithm explanation

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

### (Easy) Linked List Cycle

### Key takeaway

Use Floyd’s tortoise-and-hare: advance `slow` by 1 and `fast` by 2; if they ever meet, there’s a cycle; if `fast` hits `null`, there isn’t.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

Use **Floyd’s Tortoise and Hare** (two pointers) to detect a cycle in O(1) space:

* **Initialize pointers**:
  Set `slow = head`, `fast = head`.

* **Traverse with two speeds**:
  While `fast != null` and `fast.next != null`:

    * Move `slow = slow.next` (one step).
    * Move `fast = fast.next.next` (two steps).
    * If at any point `slow == fast`, a cycle exists → **return `true`**.

* **No cycle condition**:
  If the loop ends because `fast` reached `null` (or `fast.next == null`), the list terminates → **return `false`**.

**Why this works (invariant):**
If there’s a cycle, the faster pointer laps the slower one inside the cycle; their relative speed is 1 step per iteration, guaranteeing a meeting in at most the
cycle length many iterations after both enter the cycle.

**Edge cases:**
Empty list (`head == null`) or single node without a self-loop returns `false` immediately via the loop guard. A self-loop (`head.next == head`) is correctly
detected when `slow` and `fast` meet.

**Time Complexity**: O(n) — each pointer advances at most `n` steps before meeting or reaching `null`.
**Space Complexity**: O(1) — only a constant number of pointers are used.

### (Medium) Reorder List

#### Key takeaway

Find middle with slow/fast, split (`slow.next=null`), reverse the second half, then weave nodes alternately from first half and reversed second half until the
second is exhausted.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Remove Nth Node From End of List

#### Key takeaway

Use a dummy head and two pointers with a fixed gap `n`: advance `fast` `n+1` steps, move `fast` and `slow` together to the end, then delete `slow.next` and
return `dummy.next`.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

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

### (Medium) Copy List with Random Pointer

#### Key takeaway

Interleave clones between original nodes (`A → A' → B → B' → …`), set each clone’s `random` via `clone.random = original.random?.next`, then detach the clone
list while restoring the original.

**Time:** O(n)
**Space:** O(1) extra (excluding the output list)

#### Algorithm explanation

Use a **three-pass interleaving strategy** to copy both `next` and `random` pointers without extra hash maps:

1. **Interleave clones**
   For each original node `x`, create `x'` and splice it after `x`: set `x'.next = x.next` and `x.next = x'`.
   The list becomes `x1 → x1' → x2 → x2' → …`.

2. **Set random pointers**
   For each original `x`, its clone is `x' = x.next`.

    * If `x.random != null`, set `x'.random = x.random.next` (the clone of `x.random`).
    * Otherwise, set `x'.random = null`.

3. **Detach and restore**
   Walk the interleaved list to extract the clone chain and restore the original list:

    * Append each `x'` to the new list.
    * Restore `x.next` to the original successor (the node after `x'`).

**Time Complexity:** O(n) — three linear passes over the list
**Space Complexity:** O(1) extra — in-place interleaving (excluding the newly created copied list)

### (Medium) Add Two Numbers

#### Key takeaway

Traverse both lists with a carry: at each node sum `x + y + carry`, append a node with `sum % 10`, and update `carry = sum / 10`; continue until both lists and
carry are exhausted.

**Time:** O(max(m, n))
**Space:** O(max(m, n)) for the output list; O(1) extra workspace

#### Algorithm explanation

Use a **dummy head** to build the result list while walking both input lists in lockstep:

* **Initialize**: `carry = 0`; `dummy` sentinel and `tail = dummy`.
* **Iterate**: While at least one list has a node or `carry != 0`:

    * Read digits `x = l1.val` (or 0 if `l1 == null`) and `y = l2.val` (or 0).
    * Compute `sum = x + y + carry`; append new node with `sum % 10`.
    * Update `carry = sum / 10` and advance `l1`, `l2`, and `tail`.
* **Finish**: Return `dummy.next`.

**Why dummy head?**
It eliminates head special-casing—every new digit is appended uniformly. This iterative approach naturally handles different-length lists and a final nonzero
carry.

**Time Complexity:** O(max(m, n))
**Space Complexity:** O(max(m, n)) for the output list; O(1) extra workspace

### (Medium) Find the Duplicate Number

#### Key takeaway

Treat the array as a linked list where `i -> nums[i]`; there’s a cycle because values are in `1..n` across `n+1` indices—use Floyd’s cycle detection to find the
cycle’s entry, which equals the duplicate.

**Time:** O(n)
**Space:** O(1)

#### Algorithm explanation

* **Model as graph:** Each index points to `nums[i]`. With `n+1` nodes and values in `1..n`, the pigeonhole principle guarantees a cycle.
* **Phase 1 (meet inside cycle):** Move `slow = nums[slow]` and `fast = nums[nums[fast]]` until they meet.
* **Phase 2 (find entry):** Reset `slow = 0`, then step both one hop at a time; their meeting point is the cycle entrance → the duplicate value.

**Time Complexity:** O(n) — each pointer advances at most a constant number of full passes over the array.
**Space Complexity:** O(1) — uses only a constant number of variables.

### (Medium) LRU Cache

#### Key takeaway

Combine a **HashMap** (key → node) with a **doubly linked list** (MRU at head, LRU at tail): `get` moves the node to the front; `put` updates or inserts at the
front and evicts from the tail when capacity is exceeded.

**Time:** O(1) per `get`/`put`
**Space:** O(capacity)

#### Algorithm explanation

Maintain two data structures in sync:

* **Hash map for O(1) lookup:** Maps keys to their corresponding list nodes.
* **Doubly linked list for O(1) recency updates:**

    * **Most-recently-used (MRU)** items are placed right after a dummy `head`.
    * **Least-recently-used (LRU)** item is right before a dummy `tail`.

**Operations:**

* **get(key):**
  Look up the node in the map; if absent return `-1`. If present, **move the node to the head** (mark as MRU) and return its value.
* **put(key, value):**

    * If the key exists, update the node’s value and **move it to head**.
    * If new, create a node, **insert at head**, store in the map; **if size exceeds capacity, remove the tail’s previous node (LRU)** and delete its key from
      the map.

**Time Complexity:** O(1) per operation (hash map lookup + O(1) list splices)
**Space Complexity:** O(capacity) for the map and list nodes

### (Hard) Merge K Sorted Lists

#### Key takeaway

Use a min-heap (priority queue) of the current heads from each list: repeatedly extract the smallest node, append it, and push its successor—yielding a single
merged sorted list.

**Time:** O(N log k), where `N` is the total number of nodes and `k` is the number of lists
**Space:** O(k) extra for the heap (output list not counted)

#### Algorithm explanation

* **Initialize heap:** Push the head of each non-empty list into a min-heap keyed by node value.
* **Iteratively merge:**

    * Pop the smallest node from the heap and append it to the result list.
    * If that node has a `next`, push `next` into the heap.
* **Finish:** When the heap is empty, all nodes have been appended in sorted order; return the merged list’s head.

**Why a heap?**
At any step we need the smallest among up to `k` candidates (the current heads). A binary heap provides `O(log k)` selection/update, making the total cost
`O(N log k)`.

**Alternative (divide & conquer):**
Pairwise merge lists (like merge sort) until one remains; this also yields **O(N log k)** time and **O(1)** extra space beyond recursion/iteration, and can be
competitive in practice.

### (Hard) Reverse Nodes in k-Group

#### Key takeaway

Walk the list in blocks of size `k`; for each full block, reverse it in-place by pointing each node to the segment’s successor (`groupNext`), then splice the
reversed block back using a dummy and advance to the next block.

**Time:** O(n) — each node is visited and relinked a constant number of times
**Space:** O(1) — in-place reversal with a fixed number of pointers

#### Algorithm explanation

* **Find group:** From `groupPrev`, locate the `k`-th node (`kth`). If absent, stop—remaining nodes are fewer than `k` and remain as-is.
* **Reverse in-place:** Reverse the half-open interval `[groupPrev.next, groupNext)` by standard pointer flipping with `prev = groupNext` and
  `curr = groupPrev.next` until `curr == groupNext`.
* **Splice back:** After reversal, `kth` is the new head of the block and the old head is now the tail; connect `groupPrev.next = kth`, then set `groupPrev` to
  the block’s tail to proceed.

## Trees

### (Easy) Invert Binary Tree

#### Key takeaway

Swap every node’s left and right child. You can do this with either a BFS queue (iterative) or a DFS recursion; both visit each node once and perform a
constant-time swap per node.

**Time:** O(n) — each node visited once
**Space:**

* **BFS:** O(w) for the queue, where `w` is the maximum width (worst-case O(n))
* **DFS (recursive):** O(h) call stack, where `h` is tree height (worst-case O(n), average O(log n) for balanced trees)

#### Algorithm explanation

**Iterative BFS approach**

1. If `root == null`, return `null`.
2. Initialize a queue with `root`.
3. While the queue is not empty:

    * Pop a node `cur`.
    * Swap `cur.left` and `cur.right`.
    * If `cur.left != null`, enqueue it.
    * If `cur.right != null`, enqueue it.
4. Return `root`.

**Recursive DFS approach**

1. If `root == null`, return `null`.
2. Recursively invert the left subtree → `L = invert(root.left)`.
3. Recursively invert the right subtree → `R = invert(root.right)`.
4. Set `root.left = R` and `root.right = L`.
5. Return `root`.

**Why no “seen” set?**
Binary trees (as given in this problem) are acyclic, so each node is reached exactly once via parent → child links. A visited set adds overhead without benefit.

### (Easy) Maximum Depth of Binary Tree

#### Key takeaway

Compute depth via DFS: the depth at a node is `1 + max(depth(left), depth(right))`; base case `null → 0`.

**Time:** O(n)
**Space:** O(h) where `h` is tree height (worst-case O(n), average O(log n) for balanced)

#### Algorithm explanation

Use **recursive DFS** to return the height (max depth) of each subtree:

1. **Base case:** If `root == null`, return `0`.
2. **Recurse:** Compute `left = maxDepth(root.left)` and `right = maxDepth(root.right)`.
3. **Combine:** Return `1 + Math.max(left, right)` to account for the current node.

**Time Complexity:** O(n) — each node is visited exactly once.
**Space Complexity:** O(h) — recursion stack depth equals tree height (O(n) worst-case skewed, O(log n) on average for balanced).

*Iterative alternative (BFS):* Level-order traversal counting levels also yields O(n) time and O(w) space, where `w` is the tree’s maximum width.

### (Easy) Diameter of Binary Tree

#### Key takeaway

Do a single DFS that returns the height of each subtree while updating a global `best = leftHeight + rightHeight` at every node; the maximum such sum over the
tree is the diameter (in edges).

**Time:** O(n) — each node’s height is computed once
**Space:** O(h) — recursion stack, where `h` is tree height (O(n) worst-case skewed, O(log n) for balanced)

#### Algorithm explanation

* **Depth-first computation:**
  Write a helper `depth(node)` that returns the height (in edges) from `node` to its deepest descendant.
* **Update diameter at each node:**
  For a node, get `left = depth(node.left)` and `right = depth(node.right)`; the longest path that passes through `node` uses the deepest node in the left
  subtree and the deepest node in the right subtree, giving `left + right` edges. Update `best = max(best, left + right)`.
* **Return height:**
  The height of `node` to its parent is `max(left, right) + 1`. The final answer is the global `best` after visiting all nodes.

**Time Complexity:** O(n)
**Space Complexity:** O(h)

### (Easy) Balanced Binary Tree

#### Key takeaway

Single-pass **post-order DFS**: for each node, get `leftHeight` and `rightHeight`.

* If either is `-1` (unbalanced) or `|leftHeight - rightHeight| > 1`, return `-1`.
* Otherwise return `1 + max(leftHeight, rightHeight)`.
  Final answer: `isBalanced(root) := dfs(root) != -1`.

**Time:** O(n) — each node processed once
**Space:** O(h) — recursion stack where `h` is tree height (worst-case O(n), balanced O(log n))

#### Algorithm explanation

Use a **height-or-unbalanced** helper in post-order:

1. **Base case:** `dfs(null) = 0` (empty subtree is balanced with height 0).
2. **Recurse:**

    * `L = dfs(node.left)`; if `L == -1`, return `-1`.
    * `R = dfs(node.right)`; if `R == -1`, return `-1`.
3. **Balance check:**

    * If `|L - R| > 1`, return `-1` (current node unbalanced).
4. **Combine:**

    * Return `1 + max(L, R)` (the height for the parent to use).
5. **Result:**

    * `isBalanced(root)` is `true` iff `dfs(root) != -1`.

**Invariant (at each return):** If the subtree is balanced, the helper returns its true height; otherwise, it returns `-1`. This ensures any detected imbalance
short-circuits upward.

**Why single pass?**
Top-down “compute height at each node then compare” can degrade to `O(n^2)` on skewed trees. Bottom-up with a sentinel maintains **O(n)** by avoiding repeated
height recomputation.

**Common pitfalls:**

* Forgetting to short-circuit after detecting `-1`.
* Comparing heights before confirming both subtrees are balanced.
* Off-by-one in height definition (be consistent: `null → 0`).

## Heaps & Priority Queue

TODO

## Backtracking

TODO

## Tries

### (Medium) Implement Trie (Prefix Tree)

#### Key takeaway

Store words character-by-character in a rooted tree where each edge is a letter; `insert` creates nodes along the path and marks the last node as a word,
`search` checks that the path exists **and** ends at a word, and `startsWith` only checks path existence.

**Time:**

* `insert(word)`: O(|word|)
* `search(word)`: O(|word|)
* `startsWith(prefix)`: O(|prefix|)

**Space:** O(T) total over all inserted words (each node has up to 26 children).

### (Medium) Implement Trie (Prefix Tree)

#### Algorithm explanation

Use a **rooted tree of characters** where each node has up to 26 children (for `'a'..'z'`) and a boolean `isWord` marking the end of a stored word.

**Data structure**

* `Node`: `child[26]` array (or `Map<Character,Node>` for general alphabets) and `boolean isWord`.
* `root`: an empty `Node`.

**Operations**

1. **insert(word)**

    * Start at `root`.
    * For each character `c` in `word`:

        * Compute `idx = c - 'a'`.
        * If `child[idx] == null`, allocate a new `Node` there.
        * Move to `child[idx]`.
    * After the loop, set `isWord = true` on the last node.

2. **search(word)**

    * Traverse from `root` following each character’s child pointer.
    * If at any step the required child is `null`, return `false`.
    * After consuming all characters, return `node.isWord` (must end at a word).

3. **startsWith(prefix)**

    * Traverse from `root` following the prefix characters.
    * If any required child is `null`, return `false`.
    * If traversal succeeds, return `true` (no need to check `isWord`).

**Correctness intuition**

* Each word corresponds to a unique path from `root`; `insert` guarantees the path exists and marks its terminal node.
* `search` verifies both the path and that the terminal node represents a complete word.
* `startsWith` only verifies the path’s existence, matching the definition of “has a word with this prefix.”

**Complexities**

* `insert(word)`: O(|word|)
* `search(word)`: O(|word|)
* `startsWith(prefix)`: O(|prefix|)
* **Space:** O(T) across all words inserted, where `T` is the total number of characters stored.

O(|word|) means time proportional to the length of the input string

### (Medium) Design Add and Search Words Data Structure

#### Key takeaway

Store words in a **Trie**; `addWord` inserts characters normally, and `search` uses **DFS** to handle the wildcard `'.'` by branching over all children at that
position.

**Time:**

* `addWord(w)`: O(|w|)
* `search(w)`: Best O(|w|); worst-case with many `'.'` is O(26^d) where `d` is the number of wildcards (bounded by branching over existing children)

**Space:** O(T) for the trie nodes, where `T` is the total number of inserted characters (each node has up to 26 pointers)

#### Algorithm explanation

Use a **Trie (prefix tree)** where each node holds up to 26 children (`'a'..'z'`) and a boolean `isWord` indicating the end of a stored word.

**Data structure**

* `Node`: `Node[] child = new Node[26]; boolean isWord;`
* `root`: empty node.

**addWord(word)**

1. Set `cur = root`.
2. For each character `c` in `word`:

    * `idx = c - 'a'`.
    * If `cur.child[idx] == null`, allocate `cur.child[idx] = new Node()`.
    * `cur = cur.child[idx]`.
3. After all characters, set `cur.isWord = true`.

**search(pattern) with wildcard `'.'`**
Implement a DFS helper `matches(i, node)` that returns `true` iff `pattern[i:]` matches some word in the subtree rooted at `node`.

1. **Base case:** If `i == pattern.length()`, return `node.isWord`.
2. Let `ch = pattern.charAt(i)`.

    * **If `ch != '.'`:**

        * `idx = ch - 'a'`; let `next = node.child[idx]`.
        * If `next == null`, return `false`.
        * Else return `matches(i+1, next)`.
    * **If `ch == '.'`:**

        * For each non-null child `next` of `node`:

            * If `matches(i+1, next)` is `true`, return `true`.
        * If none succeed, return `false`.

Call `search(pattern)` as `return matches(0, root)`.

**Correctness intuition**

* `addWord` builds the unique path for the word and marks its terminal node; thus any inserted word has a path ending at `isWord = true`.
* `search` without wildcards follows exactly that path.
* On `'.'`, branching over all children explores exactly the set of letters that could occupy that position; the DFS returns `true` iff some branch reaches a
  terminal `isWord`.

**Edge cases**

* Empty string: `addWord("")` marks `root.isWord = true`; `search("")` checks `root.isWord`.
* Patterns containing only `'.'` explore at most the depth of the longest stored word; early failure occurs if a required depth is missing.
* Nonexistent paths terminate early (return `false`) without traversing the entire trie.

**Time Complexity**

* `addWord(w)`: O(|w|) — one child step per character.
* `search(w)`: Best O(|w|). Worst case with many `'.'` can branch up to 26 ways per wildcard: O(26^d), where `d` is the number of `'.'` (bounded by existing
  non-null children).

**Space Complexity**

* O(T) for all trie nodes across inserted words (`T` = total characters stored).

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