package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskSchedulerTest {

  @Test
  @DisplayName("LeetCode / NeetCode example: AAABBB with cooldown 2 -> 8")
  void exampleCase() {
    TaskScheduler solver = new TaskScheduler();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    assertEquals(8, solver.leastInterval(tasks, 2));
  }

  @Test
  @DisplayName("No cooldown (n = 0) -> just number of tasks")
  void noCooldown() {
    TaskScheduler solver = new TaskScheduler();
    char[] tasks = {'A', 'A', 'B', 'C'};
    // We can schedule them back-to-back: A A B C
    assertEquals(4, solver.leastInterval(tasks, 0));
  }

  @Test
  @DisplayName("All distinct tasks even with large cooldown need no idle")
  void allDistinctTasks() {
    TaskScheduler solver = new TaskScheduler();
    char[] tasks = {'A', 'B', 'C', 'D'};
    // All unique, cooldown 3: we can do A B C D -> 4 intervals
    assertEquals(4, solver.leastInterval(tasks, 3));
  }

  @Test
  @DisplayName("Single task type repeated with cooldown")
  void singleTaskType() {
    TaskScheduler solver = new TaskScheduler();
    char[] tasks = {'A', 'A', 'A', 'A'};
    // maxCount = 4, numMax = 1, n = 3
    // base = (4 - 1) * (3 + 1) + 1 = 3 * 4 + 1 = 13
    assertEquals(13, solver.leastInterval(tasks, 3));
  }

  @Test
  @DisplayName("Multiple max-frequency task types")
  void multipleMaxFrequencyTypes() {
    TaskScheduler solver = new TaskScheduler();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'};
    // Frequencies: A=3, B=3, C=2
    // maxCount = 3, numMax = 2, n = 2
    // base = (3 - 1) * (2 + 1) + 2 = 2 * 3 + 2 = 8
    // tasks.length = 8 -> answer = 8
    assertEquals(8, solver.leastInterval(tasks, 2));
  }

  @Test
  @DisplayName("Empty tasks array yields zero intervals")
  void emptyTasks() {
    TaskScheduler solver = new TaskScheduler();
    assertEquals(0, solver.leastInterval(new char[]{}, 2));
  }

  @Test
  @DisplayName("Invalid arguments: null tasks or negative cooldown")
  void invalidArguments() {
    TaskScheduler solver = new TaskScheduler();

    assertThrows(IllegalArgumentException.class,
        () -> solver.leastInterval(null, 1));

    assertThrows(IllegalArgumentException.class,
        () -> solver.leastInterval(new char[]{'A'}, -1));
  }
}