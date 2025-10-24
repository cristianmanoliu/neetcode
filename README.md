# NeetCode-150

https://neetcode.io/practice?tab=neetcode150

## Arrays & Hashing

### Contains Duplicate

**Main idea**:
Use a hash set to track seen elements.
As you iterate through the array, check if the current element is already in the set.
If it is, return true.
If not, add it to the set. If you finish iterating without finding duplicates, return false.

### Valid Anagram

**Main idea**:
Use a hash map to count the frequency of each character in the first string.
Then, iterate through the second string, decrementing the count for each character.
If a character's count goes below zero or if a character is not found in the map, return false.
Finally, check if all counts are zero to confirm the strings are anagrams.

Instead of a hash map, you can also use an array of size 26 (for lowercase letters) to count character frequencies, which can be more space-efficient.

### Two Sum

**Main idea**:
Use a hash map to store the complement of each number (target - current number) as you iterate through the array.
If the current number exists in the map, return the indices of the current number and its complement.
If not, add the current number and its index to the map.

### Group Anagrams

**Main idea**:
Use a hash map where the key is a sorted version of the string and the value is a list of strings that are anagrams of each other.
Iterate through the list of strings, sort each string, and append it to the corresponding list in the map.
Finally, return the values of the map as a list of lists.

We can also use an array of size 26 to count character frequencies as a key instead of sorting, which can be more efficient.
The array can be hashed or converted to a tuple to be used as a key in the hash map.

### Top K Frequent Elements

**Main idea**:
Use a hash map to count the frequency of each element in the array.
Then, use a min-heap (priority queue) to keep track of the top k elements based on their frequencies.
Iterate through the frequency map, adding elements to the heap.
If the heap size exceeds k, remove the element with the lowest frequency.
Finally, extract the elements from the heap to get the top k frequent elements.

### Encode and Decode Strings

**Main idea**:
To encode a list of strings, concatenate them into a single string with a delimiter that does not appear in the strings (e.g., using length-prefix encoding).
To decode, split the encoded string using the delimiter and reconstruct the original list of strings.

### Product of Array Except Self

**Main idea**:
Use two passes to calculate the product of all elements except self without using division.
In the first pass, create an output array where each element at index i contains the product of all elements to the left of i.
In the second pass, traverse the array from the end, multiplying each element in the output array by the product of all elements to the right of i.

### Valid Sudoku

**Main idea**:
Use three sets of hash sets to track the numbers seen in each row, column, and 3x3 sub-box.
Iterate through each cell in the 9x9 board.
For each number, check if it has already been seen in the corresponding row, column, or sub-box.
If it has, return false.
If not, add it to the respective sets.
If you finish iterating without finding duplicates, return true.

The 3x3 sub-box can be identified using the formula: box_index = (row // 3) * 3 + (col // 3).

### Longest Consecutive Sequence

**Main idea**:
Use a hash set to store all unique numbers from the array.
Iterate through the array, and for each number, check if it is the start of a sequence (i.e., num - 1 is not in the set).
If it is, count the length of the sequence by incrementing from that number until you reach a number not in the set.
Keep track of the maximum sequence length found during the iteration.¬

## Two Pointers

### Valid Palindrome

**Main idea**:
Place one pointer at the string's start and another at its end, advance both pointers toward the center, skipping non-alphanumeric characters and ignoring case
differences.
If characters at both pointers match, continue; if they don't, return false.
If the pointers cross without mismatches, return true.

### Two Sum II - Input Array Is Sorted

**Main idea**:
Use two pointers, one starting at the beginning (left) and the other at the end (right) of the sorted array.
Calculate the sum of the elements at both pointers.
If the sum equals the target, return the indices (adjusted for 1-based indexing).
If the sum is less than the target, move the left pointer to the right to increase the sum.
If the sum is greater than the target, move the right pointer to the left to decrease the sum.
Continue this process until the pointers meet.

### 3Sum

**Main idea**:
Sort the array to facilitate the two-pointer approach.
Iterate through the array, fixing one element at a time.
For each fixed element, use two pointers (left and right) to find pairs that sum to the negative of the fixed element.
Skip duplicate elements to avoid repeating triplets.
Collect unique triplets in a result list and return it.

### Container With Most Water

**Main idea**:
Use two pointers, one at the beginning (left) and one at the end (right) of the array.
Calculate the area formed by the lines at both pointers and the x-axis.
Keep track of the maximum area found.
Move the pointer pointing to the shorter line inward, as this may lead to a larger area.
Repeat the process until the pointers meet.

Also, calculate the area using the formula: area = min(height[left], height[right]) * (right - left).
Move the pointer of the shorter line because the area is limited by the shorter line, and moving it inward may find a taller line that increases the area.

### Trapping Rain Water

**Main idea**:
Use two pointers, one at the beginning (left) and one at the end (right) of the array.
Maintain two variables to track the maximum height seen from the left and right sides (left_max and right_max).
Calculate the trapped water at each position based on the minimum of left_max and right_max minus the current height.
Move the pointer pointing to the shorter line inward, updating left_max or right_max as needed.
Continue this process until the pointers meet.

The trapped water at each position can be calculated as: water += min(left_max, right_max) - height[current_position]

## Sliding Window

### Best Time to Buy and Sell Stock

**Main idea**:
Use a single pass through the array to track the minimum price seen so far and calculate the maximum profit at each step.
Each time you encounter a new price, check if selling at that price would yield a higher profit than previously recorded.
Update the minimum price if the current price is lower than the recorded minimum.

### Longest Substring Without Repeating Characters

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring.
Use a hash set to track characters in the current window.
Expand the right pointer to include new characters and check for duplicates.
If a duplicate is found, move the left pointer to the right until the duplicate is removed.
Keep track of the maximum length of the substring found during the process.

### Longest Repeating Character Replacement

**Main idea**:
Use a sliding window approach with two pointers (left and right) to represent the current substring.
Use a hash map to count the frequency of characters in the current window.
Calculate the maximum frequency of any character in the window.
If the number of characters that need to be replaced (window size - max frequency) exceeds k, move the left pointer to the right to shrink the window.
Keep track of the maximum length of the substring found during the process.

Frequency of characters can be tracked using an array of size 26 for uppercase letters to optimize space and access time.

### Permutation in String

**Main idea**:

### Minimum Window Substring

**Main idea**:

### Sliding Window Maximum

**Main idea**:

## Stack

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
