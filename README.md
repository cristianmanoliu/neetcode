# NeetCode-150

[NeetCode-150](https://neetcode.io/practice?tab=neetcode150)

> Note: Big-O notation describes asymptotic growth. It is commonly used to denote an upper bound (often the worst-case) unless an average or best case is
> explicitly stated.

**Notation / conventions**

- Unless stated otherwise, let `n` be the length of the main input array or string.
- For grids, `m × n` means `m` rows and `n` columns.
- For graphs/trees, `n` is the number of nodes.
- Unless stated otherwise, hash map / hash set operations are assumed **O(1) amortized**, and heap push/pop operations are **O(log k)** where `k` is the heap
  size.
- The base of the logarithm in `O(log n)` is irrelevant for Big-O (different bases differ only by a constant factor).

## Big O Notation - Time and Space Complexity

---

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

## Arrays & Hashing

---

### (Easy) Contains Duplicate

#### Key takeaway

Scan once with a hash set; if you see a value already in the set, return true, else insert and finish with false.

**Time:** O(n)  
**Space:** O(n)

### (Easy) Valid Anagram

#### Key takeaway

If lengths match, count chars from `s` and decrement with `t`; any negative/missing count means false, otherwise true (e.g., int[26]).

**Time:** O(n)  
**Space:** O(1) with fixed alphabet (otherwise O(k)).

### (Easy) Two Sum

#### Key takeaway

Single pass with a map `val → index`; for each `x` check if `target-x` is in the map, otherwise store `x`.

**Time:** O(n)  
**Space:** O(n)

### (Medium) Group Anagrams

#### Key takeaway

Use a map from a canonical form (sorted string or 26-count signature) to a list of words and return the groups.

**Time:** O(n·k log k) with sorting, O(n·k) with counts  
**Space:** O(n·k)

### (Medium) Top K Frequent Elements

#### Key takeaway

Count frequencies with a map, then keep a size-`k` min-heap of `(freq, value)` entries, popping the smallest when size > k.

**Time:** O(n log k)  
**Space:** O(n)

### (Medium) Encode and Decode Strings

#### Key takeaway

Encode each string as `len#string` and concatenate; decode by reading length up to `#` and then slicing that many characters.

**Time:** O(T) over total characters  
**Space:** O(T) for encoded/decoded output.

Here `T` denotes the total number of characters across all strings in the input.

### (Medium) Product of Array Except Self

#### Key takeaway

Build prefix products into the output array, then sweep from the right with a suffix product and multiply into each position.

**Time:** O(n)  
**Space:** O(1) extra (excluding output).

### (Medium) Valid Sudoku

#### Key takeaway

For each filled cell, check/insert its digit in row/column/box sets; any duplicate makes the board invalid.

**Time:** O(1) for the fixed 9×9 board (81 cells); **O(N²)** if generalized to an N×N board  
**Space:** O(1) for fixed 9×9 (constant-size sets); **O(N²)** if generalized (rows + cols + boxes)

### (Medium) Longest Consecutive Sequence

#### Key takeaway

Put all numbers in a set and, for numbers without a `x-1` predecessor, expand forward to count the length of the run.

**Time:** O(n)  
**Space:** O(n)

## Two Pointers

---

### (Easy) Valid Palindrome

#### Key takeaway

Use two pointers skipping non-alphanumerics; compare lowercase chars and return false on mismatch, true if you finish.

**Time:** O(n)  
**Space:** O(1)

### (Medium) Two Sum II - Input Array Is Sorted

#### Key takeaway

With a sorted array, use two pointers `l,r`; move `l` up if sum < target, `r` down if sum > target, and return indices on exact match.

**Time:** O(n)  
**Space:** O(1)

### (Medium) 3Sum

#### Key takeaway

Sort the array, then for each index `i` (skipping duplicates) use a two-pointer sweep to find complementary pairs to `-nums[i]`.

**Time:** O(n²) (dominated by the outer loop × two-pointer)  
**Space:** O(1) extra (or O(n) depending on sort).

### (Medium) Container With Most Water

#### Key takeaway

Two pointers at the ends; track max area and always move the pointer at the shorter height inward.

**Time:** O(n)  
**Space:** O(1)

### (Hard) Trapping Rain Water

#### Key takeaway

Two pointers maintaining `leftMax` and `rightMax`; move the smaller side inward and accumulate trapped water from that side.

**Time:** O(n)  
**Space:** O(1)

## Sliding Window

---

### (Easy) Best Time to Buy and Sell Stock

#### Key takeaway

Track `minSoFar` while scanning prices and update max profit as `price - minSoFar`.

**Time:** O(n)  
**Space:** O(1)

### (Medium) Longest Substring Without Repeating Characters

#### Key takeaway

Slide a window with `l,r` and a map of last positions; move `l` after duplicates and track the maximum window length.

**Time:** O(n)  
**Space:** O(min(n, m)) (m = alphabet size).

### (Medium) Longest Repeating Character Replacement

#### Key takeaway

Maintain counts and the max frequency in the window; shrink from the left while replacements needed exceed `k`, tracking best length.

**Time:** O(n)  
**Space:** O(1) for fixed alphabet (else O(m)).

### (Medium) Permutation in String

#### Key takeaway

Keep 26-counts for `s1` and a sliding window of length `|s1|` over `s2`; if any window’s counts match, return true.

**Time:** O(|s2|) over `s2` (O(1) per step with 26 buckets)  
**Space:** O(1) for fixed lowercase alphabet (else O(k) for alphabet size `k`)

### (Hard) Minimum Window Substring

#### Key takeaway

Grow the window to satisfy counts for all chars in `t`, then shrink from the left while valid to track the smallest such window.

**Time:** O(|s| + |t|)  
**Space:** O(k) (distinct chars in `t`).

### (Hard) Sliding Window Maximum

#### Key takeaway

Maintain a deque of indices with decreasing values; the front is always the max of the current window.

**Time:** O(n)  
**Space:** O(k)

## Stack

---

### (Easy) Valid Parentheses

#### Key takeaway

Use a stack to push opening brackets and pop/check on closing ones; valid if the stack is empty at the end.

**Time:** O(n)  
**Space:** O(n)

### (Medium) Min Stack

#### Key takeaway

Keep a parallel stack of running minimums so `getMin()` is just the top of the min stack.

**Time:** O(1) for all operations  
**Space:** O(n) (parallel min stack)

### (Medium) Evaluate Reverse Polish Notation

#### Key takeaway

Push numbers on a stack; on an operator, pop two numbers, apply the operator, and push the result back.

**Time:** O(n)  
**Space:** O(n)

### (Medium) Generate Parentheses

#### Key takeaway

Backtrack by adding `'('` when open < n and `')'` when close < open until you build all valid strings of length 2n.

**Time:** O(4^n/√n) (≈ Catalan count; equivalently O(Cₙ·n) including output length)  
**Space:** O(n) recursion stack (excluding output)

### (Medium) Daily Temperatures

#### Key takeaway

Use a monotonic decreasing stack of indices; for each day, pop and set its answer when you find a warmer day.

**Time:** O(n)  
**Space:** O(n)

### (Medium) Car Fleet

#### Key takeaway

Sort cars by position descending and sweep once, forming a new fleet whenever a car’s time to target is greater than the last fleet time.

**Time:** O(n log n) (sorting dominates)  
**Space:** O(n) for pairs/stack (can be O(1) extra with in-place sort + counter)

### (Hard) Largest Rectangle in Histogram

#### Key takeaway

Use a stack of increasing bar indices and, when a shorter bar appears, pop and compute area with that bar as height.

**Time:** O(n)  
**Space:** O(n) (stack)

## Binary Search

---

### (Easy) Binary Search

#### Key takeaway

Standard binary search: compare mid with target and shrink the search interval until found or empty.

**Time:** O(log n)  
**Space:** O(1)

### (Medium) Search in 2D Matrix

#### Key takeaway

Treat the matrix as a flattened sorted array and binary-search indices, mapping mid back to (row, col).

**Time:** O(log(m·n))  
**Space:** O(1)

### (Medium) Koko Eating Bananas

#### Key takeaway

Binary search the eating speed `k` from 1 to max pile and check if Koko can finish within `h` hours for a given `k`.

**Time:** O(n · log max(piles))  
**Space:** O(1)

### (Medium) Find Minimum in Rotated Sorted Array

#### Key takeaway

Binary search using the fact that at least one half is sorted; move toward the unsorted side until you find the minimum.

**Time:** O(log n)  
**Space:** O(1)

### (Medium) Search in Rotated Sorted Array

#### Key takeaway

Binary search while deciding whether the left or right half is sorted and if the target lies in that half.

**Time:** O(log n)  
**Space:** O(1)

### (Medium) Time Based Key-Value Store

#### Key takeaway

Store `(timestamp, value)` lists per key and binary-search the latest timestamp ≤ query time on `get`.

**Time:** `set` amortized O(1); `get` O(log m) per key (m = versions for that key)  
**Space:** O(N) total over all `set` calls (sum of all stored `(timestamp, value)` pairs)

### (Hard) Median of Two Sorted Arrays

#### Key takeaway

Binary search a partition in the smaller array so left parts and right parts form a valid split around the median.

**Time:** O(log min(m, n)), where `m = |nums1|` and `n = |nums2|`  
**Space:** O(1)

## Linked List

---

### (Easy) Reverse Linked List

#### Key takeaway

Iteratively reverse pointers using `prev` and `curr` so each node points to its predecessor.

**Time:** O(n)  
**Space:** O(1)

### (Easy) Merge Two Sorted Lists

#### Key takeaway

Use a dummy node and merge by always taking the smaller head from the two lists.

**Time:** O(m+n)  
**Space:** O(1)

### (Easy) Linked List Cycle

#### Key takeaway

Use slow and fast pointers; if they ever meet, there is a cycle, otherwise none.

**Time:** O(n)  
**Space:** O(1)

### (Medium) Reorder List

#### Key takeaway

Split the list in half, reverse the second half, and then interleave nodes from the two halves.

**Time:** O(n)  
**Space:** O(1)

### (Medium) Remove Nth Node From End of List

#### Key takeaway

Use a dummy and two pointers separated by `n` nodes; move both until fast hits null, then delete `slow.next`.

**Time:** O(n)  
**Space:** O(1)

### (Medium) Copy List with Random Pointer

#### Key takeaway

Interleave cloned nodes inside the original list, set their random pointers using neighbors, then detach the clone list.

**Time:** O(n)  
**Space:** O(1) extra (excluding the output list)

### (Medium) Add Two Numbers

#### Key takeaway

Traverse both lists with a carry, creating a result list node-by-node from the digit sums.

**Time:** O(max(m, n))  
**Space:** O(max(m, n)) for the output list; O(1) extra workspace

### (Medium) Find the Duplicate Number

#### Key takeaway

Treat the array as a linked list `i → nums[i]` and use Floyd’s cycle detection to find the entry point of the cycle.

**Time:** O(n)  
**Space:** O(1)

### (Medium) LRU Cache

#### Key takeaway

Combine a map for O(1) key lookup with a doubly linked list storing items in MRU→LRU order.

**Time:** O(1) per `get`/`put`  
**Space:** O(capacity)

### (Hard) Merge K Sorted Lists

#### Key takeaway

Push each list’s head into a min-heap and repeatedly pop the smallest node, pushing its successor.

**Time:** O(N log k), where `N` is the total number of nodes and `k` is the number of lists  
**Space:** O(k) extra for the heap (output list not counted)

### (Hard) Reverse Nodes in k-Group

#### Key takeaway

Walk the list in chunks of `k`; for each full chunk, reverse it in place and stitch it back into the list.

**Time:** O(n) — each node is visited and relinked a constant number of times  
**Space:** O(1) — in-place reversal with a fixed number of pointers

## Trees

---

### (Easy) Invert Binary Tree

#### Key takeaway

DFS or BFS over the tree and swap left and right children at every node.

**Time:** O(n) — each node visited once  
**Space:**

- **BFS:** O(w) for the queue, where `w` is the maximum width (worst-case O(n))
- **DFS (recursive):** O(h) call stack, where `h` is tree height (worst-case O(n), average O(log n) for balanced trees)

### (Easy) Maximum Depth of Binary Tree

#### Key takeaway

Use DFS where depth is `1 + max(depth(left), depth(right))`, with null giving 0.

**Time:** O(n)
**Space:** O(h) where `h` is tree height (worst-case O(n), average O(log n) for balanced)

### (Easy) Diameter of Binary Tree

#### Key takeaway

DFS that returns subtree heights and updates a global best `leftHeight + rightHeight` at each node.

**Time:** O(n) — each node’s height is computed once  
**Space:** O(h) — recursion stack, where `h` is tree height (O(n) worst-case skewed, O(log n) for balanced)

### (Easy) Balanced Binary Tree

#### Key takeaway

Post-order DFS that returns subtree height or -1 if unbalanced; any node with height difference > 1 marks the tree unbalanced.

**Time:** O(n) — each node processed once
**Space:** O(h) — recursion stack where `h` is tree height (worst-case O(n), balanced O(log n))

### (Easy) Same Tree

#### Key takeaway

Recursively compare both trees; nodes must both be null, or both non-null with equal values and equal left/right subtrees.

**Time:** O(n) where `n` is the number of nodes compared (min size of the two trees if early exit)  
**Space:** O(h) recursion stack, where `h` is tree height (worst-case O(n) for skewed, O(log n) for balanced)

### (Easy) Subtree of Another Tree

#### Key takeaway

For each node in `root`, check with an `isSameTree` helper whether the subtree rooted there is exactly equal to `subRoot`.

**Time:** O(m · n) in the worst case, where `m = |root|` and `n = |subRoot|`  
**Space:** O(h) recursion stack, where `h` is tree height (worst case O(m + n) for very skewed trees)

### (Medium) Lowest Common Ancestor in Binary Search Tree

#### Key takeaway

Starting from `root`, if both `p` and `q` are less than the current node go left; if both are greater go right; otherwise the current node is their LCA.

**Time:** O(h) where `h` is tree height (O(log n) average for balanced BST, O(n) worst-case)  
**Space:** O(1) extra

### (Medium) Binary Tree Level Order Traversal

#### Key takeaway

Do a BFS using a queue: while the queue is not empty, take its current size as the level size, pop exactly that many nodes (collecting their values), and
enqueue each node’s children to form the next level.

**Time:** O(n) — each node is enqueued and dequeued once  
**Space:** O(n) — queue + output store up to O(n) nodes

### (Medium) Binary Tree Right Side View

#### Key takeaway

Do a BFS using a queue: while the queue isn’t empty, take the current size as the level size, pop exactly that many nodes, record the last node’s value as the
right view for that level, and enqueue each node’s children.

**Time:** O(n) — each node is visited once

**Space:** O(w) — queue holds up to the tree’s maximum width

### (Medium) Count Good Nodes in Binary Tree

#### Key takeaway

Do a DFS from the root, carrying the maximum value seen along the current path. A node is “good” if node.val >= maxSoFar. Count it, update maxSoFar, and recurse
to children.

**Time:** O(n) — each node visited once
**Space:** O(h) — recursion stack (worst-case O(n) for a skewed tree)

### (Medium) Validate Binary Search Tree

#### Key takeaway

Do a DFS carrying a valid range (low, high) for each node. A node is valid only if low < node.val < high. Recurse left with (low, node.val) and right with (
node.val, high). Use long bounds to avoid edge cases near Integer.MIN_VALUE/MAX_VALUE.

**Time:** O(n) — visit each node once
**Space:** O(h) — recursion stack (worst-case O(n) for a skewed tree)

### (Medium) Kth Smallest Integer in BST

#### Key takeaway

Do an inorder traversal (left → node → right) which yields nodes in ascending order. Use a stack to push the left chain, pop one node at a time, decrement k,
and when k == 0, return that node’s value.

**Time:** O(h + k) on average (O(n) worst-case) — you visit nodes up to the k-th
**Space:** O(h) — stack proportional to the tree height

### (Medium) Construct Binary Tree from Preorder and Inorder Traversal

#### Key takeaway

Use a hash map for inorder value → index. Recurse using a moving pointer on preorder: take the next value as root, split the inorder range at root’s index into
left/right subtrees, build left first, then right. Avoid array slicing by passing indices.

**Time:** O(n) — each node/position processed once
**Space:** O(n) — hash map + recursion stack (worst-case height n)

### (Hard) Binary Tree Maximum Path Sum

#### Key takeaway

Use DFS that returns the max gain up to the parent from each node. For each node, compute leftGain and rightGain (clamped at 0 to discard negative paths).
Update a global maxSum with node.val + leftGain + rightGain, and return node.val + max(leftGain, rightGain) to the parent.

**Time:** O(n) — visit each node once
**Space:** O(h) — recursion stack (worst-case O(n) for skewed tree)

### (Hard) Serialize and Deserialize Binary Tree

#### Key takeaway

Use preorder DFS with a sentinel for nulls. During serialize, append val or "N" plus a delimiter. During deserialize, read tokens in order: on "N" return null;
otherwise create a node and recursively build its left and right subtrees.

**Time:** O(n) — each node/token processed once
**Space:** O(n) — output string + recursion stack (worst-case height n)

## Heaps & Priority Queue

### (Easy) Kth Largest Element in a Stream

#### Key takeaway

Maintain a min-heap of size `k` that always stores the `k` largest values seen so far; after each insertion, the heap’s root is the current k-th largest
element.

**Time:** O(n log k) to build, O(log k) per `add`  
**Space:** O(k)

### (Easy) Last Stone Weight

#### Key takeaway

Use a max-heap to always pull the two heaviest stones, smash them, and if their weights differ push the difference back until at most one stone remains; that
weight (or 0) is the answer.

**Time:** O(n log n)  
**Space:** O(n)

### (Medium) K Closest Points to Origin

#### Key takeaway

Maintain a size-k max-heap by squared distance. Push each point; if the heap grows beyond k, pop the farthest. The heap ends up holding the k closest points.

**Time:** O(n log k) — each of n points causes at most one heap insertion and (sometimes) one deletion
**Space:** O(k) — the heap stores up to k points

### (Medium) Kth Largest Element in an Array

#### Key takeaway

Maintain a min-heap of size `k`: push every number into the heap, and whenever its size exceeds `k`, pop the smallest; after processing the whole array, the
heap’s root is the k-th largest element.

**Time:** O(n log k)  
**Space:** O(k)

### (Medium) Task Scheduler

#### Key takeaway

Count how often each task appears, find the maximum frequency and how many tasks share it, then apply  
`max(tasks.length, (maxCount - 1) * (n + 1) + numMax)` to get the minimum number of intervals, since the most frequent tasks dictate the idle slots needed.

**Time:** O(T), where T = number of tasks  
**Space:** O(1) (only 26 frequency counters)

### (Medium) Design Twitter

#### Key takeaway

Store each user’s tweets as a reverse-chronologically linked list and the follow graph as a map from user to followees; build a news feed by k-way merging the
heads of all followed users’ tweet lists using a max-heap to pull the 10 most recent tweets.

**Time:** `postTweet` / `follow` / `unfollow` → O(1); `getNewsFeed` → O((F + K) log F), where F is the number of followed users and K = 10  
**Space:** O(U + F + T) for users, follow relationships, and stored tweets

### (Hard) Find Median from Data Stream

#### Key takeaway

Maintain two heaps: a max-heap for the lower half of the numbers and a min-heap for the upper half, rebalancing them so their sizes differ by at most one; the
median is then either the top of the larger heap or the average of both tops.

**Time:** O(log n) per `addNum`, O(1) per `findMedian`  
**Space:** O(n)

## Backtracking

### (Medium) Subsets (Power Set)

#### Key takeaway

Use backtracking to build subsets by exploring, for each position, whether to include the current element or skip it; at every recursion level, record the
current partial choice as one valid subset.

**Time:** O(n · 2^n)  
**Space:** O(n) extra for recursion and the current path (O(n · 2^n) including the output)

### (Medium) Generate Parentheses

#### Key takeaway

Use backtracking with counts of open and close parentheses to build only valid prefixes: add `'('` while you still can, add `')'` only when there are more opens
than closes, and record each length-`2n` string as a solution.

**Time:** O(Cₙ · n), where Cₙ is the n-th Catalan number  
**Space:** O(n) extra for recursion and the current string (excluding the output list)

## Tries

### (Medium) Implement Trie (Prefix Tree)

#### Key takeaway

Store each word as a path from the root; `insert` builds nodes, `search` checks full path + `isWord`, `startsWith` checks only the path.

**Time:**

- `insert(word)`: O(|word|)
- `search(word)`: O(|word|)
- `startsWith(prefix)`: O(|prefix|)

**Space:** O(T) total over all inserted words (each node has up to 26 children).

`O(|word|)` means time proportional to the length of the input string.

### (Medium) Design Add and Search Words Data Structure

#### Key takeaway

Use a trie; `addWord` inserts normally, and `search` does DFS, branching over all children when it sees `'.'`.

**Time:**

- `addWord(w)`: O(|w|)
- `search(w)`: Best O(|w|); worst-case with many `'.'` is O(26^d) where `d` is the number of wildcards (bounded by branching over existing children)

**Space:** O(T) for the trie nodes, where `T` is the total number of inserted characters (each node has up to 26 pointers)

## Graphs

### (Medium) Number of Islands

#### Key takeaway

Scan the grid and, for each unvisited land cell, run DFS/BFS to flood-fill its connected component and count it as one island.

**Time:** O(m · n) for an m × n grid  
**Space:** O(m · n) in the worst case for recursion stack or BFS queue (O(1) extra if visited cells are marked in-place)

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

### (Easy) Single Number

#### Key takeaway

Fold the array with XOR. Since x ^ x = 0 and x ^ 0 = x, every paired element cancels out, leaving the lone element as the result.

**Time:** O(n) — single pass
**Space:** O(1) — constant extra space

### (Easy) Number of 1 Bits

#### Key takeaway

Use Brian Kernighan’s trick: repeatedly clear the lowest set bit with n &= (n - 1) and count iterations. Each iteration removes exactly one 1.

Time: O(k) — k = number of set bits (≤ 32)
Space: O(1) — constant extra space

### (Easy) Counting Bits

#### Key takeaway

Use the DP recurrence bits[i] = bits[i >> 1] + (i & 1): drop the least-significant bit by shifting right and add 1 if that dropped bit was 1. Build from 0 to n.

**Time:** O(n) — one O(1) step per i
**Space:** O(n) — the output array


---

# Patterns Recognition Cheat Sheet

## Arrays & Hashing

> When you need to track, count, or lookup elements in O(1), reach for a hash map or set first.

- If you see **"frequency," "duplicate," or "group by,"** you're likely hashing.
- For **"Top K"** problems, combine a hash map with a heap.

## Two Pointers

> Sorted data or need to compare/combine elements from opposite ends or different positions? Use two pointers.

- One pointer often chases the other, or they squeeze inward from both ends.
- The key idea: pointers interact but don't care about what's *between* them.

## Sliding Window

> If the problem asks about a **contiguous subarray/substring** with specific properties (max, min, or constraint), slide a window.

- Unlike two pointers, you **do** care about everything inside the window.
- Expand the right side to include more.
- Shrink the left side when the window becomes invalid.

## Stack

> Think stack when you need to remember previous elements and process them in reverse order or when something "invalidates" earlier items.

- Look for: **matching pairs**, **nearest greater/smaller element**, or building something that depends on what came before.

## Binary Search

> Not just for sorted arrays! Use binary search whenever you can eliminate half the search space by comparing against a midpoint.

- Key phrase: **"minimize/maximize X such that condition Y holds"** → binary search on the *answer space*.

## Linked List

> Draw it out! Linked list problems are all about pointer manipulation.

- Use a **dummy node** to simplify edge cases.
- Fast/slow pointers detect cycles.
- You can often solve in-place with **O(1)** extra space by rewiring pointers.

## Trees

> Trees = choose your traversal wisely. DFS (recursion) for depth/path problems, BFS (queue) for level/shortest-path problems.

- **Post-order** when children inform parent.
- **Pre-order** when parent informs children.
- Always consider: what info does each node need from its subtrees?

## Heaps & Priority Queue

> When you need the min/max repeatedly or must process elements in sorted order dynamically, use a heap.

- Classic indicators:
    - **Kth largest/smallest**
    - **Merge K sorted structures**
    - **Median from stream**
- Heap gives you **O(log k)** operations.

## Backtracking

> Generate all possible solutions by making choices, exploring paths, then undoing (backtracking) to try other options.

- Keywords: **"all combinations," "all permutations," "generate all valid"**.
- Think recursive tree where you build and tear down state.

## Tries

> Prefix problems? Build a trie (prefix tree). Each path from root = a string.

- Perfect for:
    - **"starts with"**
    - **Autocomplete**
    - **Dictionary-based word searches**
- Each node branches on the next character.

## Graph

> DFS for connectivity/components, BFS for shortest paths (in unweighted graphs).

- Always track **visited** nodes to avoid cycles.
- Grid problems are often hidden graphs—treat cells as nodes and adjacent cells as edges.

## Dynamic Programming

> Can you break it into smaller overlapping subproblems with optimal substructure?

- Signals:
    - **"maximize/minimize"**
    - **"count ways"**
    - **"is it possible"**
- Common patterns:
    - **Knapsack** (choices)
    - **LCS / edit distance** (two sequences)
    - **Interval DP** (range/segment problems)

## Greedy

> Make the locally optimal choice at each step without looking back.

- Only valid when **local optimum = global optimum**.
- Common in:
    - Interval scheduling
    - Minimum coins (for certain denominations)
    - Problems where you **sort first**, then sweep.

## Intervals

> Sort intervals by start time, then merge/process sequentially.

- For overlapping intervals, check if `start2 ≤ end1`.
- Most interval problems reduce to:
    1. Sort by start.
    2. Sweep while maintaining a current interval and comparing.

## Bit Manipulation

> Think powers of 2 and bitwise operators (`&`, `|`, `^`, `~`, `<<`, `>>`).

- XOR tricks for finding unique elements.
- AND/OR for masks.
- Remember: `n & (n - 1)` clears the lowest set bit—useful for counting bits.