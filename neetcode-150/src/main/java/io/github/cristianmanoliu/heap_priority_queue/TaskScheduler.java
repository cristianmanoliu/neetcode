package io.github.cristianmanoliu.heap_priority_queue;

// https://neetcode.io/problems/task-scheduling?list=neetcode150
// https://leetcode.com/problems/task-scheduler/

public class TaskScheduler {

  // Compute the least number of time intervals needed to finish all tasks
  // such that identical tasks are separated by at least 'n' intervals.
  //
  // Key idea (counting + greedy formula):
  // - Count how many times each task appears.
  // - Let maxCount be the highest frequency among tasks.
  // - Let numMax be the number of tasks that appear maxCount times.
  // - Picture the most frequent tasks arranged first, with 'n' gaps between them:
  //       [X . . X . . ... X]   where X is a max-frequency task
  //   We have (maxCount - 1) "full" rows, each of length (n + 1)
  //   and a final row that contains all tasks that share the max frequency (numMax).
  //   This gives a minimal length:
  //       base = (maxCount - 1) * (n + 1) + numMax
  // - The result is max(base, tasks.length) because if we have enough
  //   different tasks to fill idle slots, the schedule length is just tasks.length.
  public int leastInterval(char[] tasks, int n) {
    if (tasks == null) {
      throw new IllegalArgumentException("tasks must not be null");
    }
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }
    // Edge case: no tasks -> no intervals needed.
    if (tasks.length == 0) {
      return 0;
    }

    // Frequency array for uppercase letters 'A' to 'Z'.
    int[] freq = new int[26];

    // Count how many times each task appears.
    for (char task : tasks) {
      freq[task - 'A']++;
    }

    // Find the maximum frequency.
    int maxCount = 0;
    for (int count : freq) {
      if (count > maxCount) {
        maxCount = count;
      }
    }

    // Count how many tasks share this maximum frequency.
    int numMax = 0;
    for (int count : freq) {
      if (count == maxCount) {
        numMax++;
      }
    }

    // Number of "full" rows formed by the most frequent tasks.
    int partCount = maxCount - 1;

    // Length of each such row: one max-frequency task + 'n' slots.
    int partLength = n + 1;

    // Minimal length imposed by the most frequent tasks pattern.
    int base = partCount * partLength + numMax;

    // Final answer: either we are constrained by the idle structure (base),
    // or we simply use all tasks without idle (tasks.length).
    return Math.max(tasks.length, base);
  }
}