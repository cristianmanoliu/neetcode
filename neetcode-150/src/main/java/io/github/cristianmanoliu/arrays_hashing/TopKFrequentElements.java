package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150
// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

  // Main function: return the k most frequent elements from the array.
  // Strategy:
  // 1) Count frequencies with a HashMap.
  // 2) Push (num, freq) entries into a max-heap ordered by frequency.
  // 3) Pop the top k entries and collect their keys.
  //
  // Note: This is O(U log U) where U is the number of unique elements.
  // (A bucket-sort variant can do O(n), but heap is simple and accepted.)
  public int[] topKFrequent(int[] nums, int k) {
    // Handle edge cases: k == 0 or empty/null input
    if (k == 0 || nums == null || nums.length == 0) {
      return new int[] {};
    }

    // Count frequency of each number
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Max-heap by frequency (highest freq at head)
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    // Add all (num, freq) entries to the heap
    maxHeap.addAll(freq.entrySet());

    // Extract up to k most frequent numbers
    int take = Math.min(k, freq.size());
    int[] res = new int[take];
    for (int i = 0; i < take; i++) {
      res[i] = maxHeap.poll().getKey();
    }

    return res;
  }
}
