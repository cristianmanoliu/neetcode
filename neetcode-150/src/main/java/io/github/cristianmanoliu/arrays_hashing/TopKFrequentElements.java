package io.github.cristianmanoliu.arrays_hashing;

public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    if (k == 0) {
      return new int[]{}; // Return empty array if k is 0
    }
    if (nums == null || nums.length == 0) {
      return new int[]{}; // Return empty array if input is empty
    }

    // Count the frequency of each number
    java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Create a max heap based on frequency
    java.util.PriorityQueue<java.util.Map.Entry<Integer, Integer>> maxHeap =
        new java.util.PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    // Add all entries to the max heap
    for (java.util.Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      maxHeap.offer(entry);
    }

    // Extract the top k frequent elements
    int[] result = new int[Math.min(k, frequencyMap.size())];
    for (int i = 0; i < result.length; i++) {
      if (!maxHeap.isEmpty()) {
        result[i] = maxHeap.poll().getKey();
      }
    }

    return result;
  }
}
