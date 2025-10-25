package io.github.cristianmanoliu.stack;

import java.util.Arrays;
import java.util.Stack;

// https://neetcode.io/problems/car-fleet?list=neetcode150
// https://leetcode.com/problems/car-fleet/
public class CarFleet {

  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;

    // Create array of Car objects pairing position with speed
    Car[] cars = new Car[n];
    for (int i = 0; i < n; i++) {
      cars[i] = new Car(position[i], speed[i]);
    }

    // Sort by position in descending order (closest to target first)
    Arrays.sort(cars, (a, b) -> b.position - a.position);

    Stack<Double> stack = new Stack<>();

    // Process each car from closest to target
    for (Car car : cars) {
      // Calculate time to reach target
      double timeToReach = (double) (target - car.position) / car.speed;

      // If stack is empty or current car takes longer than previous fleet,
      // it forms a new fleet
      if (stack.isEmpty() || timeToReach > stack.peek()) {
        stack.push(timeToReach);
      }
      // Otherwise, current car catches up to the fleet ahead (merges)
    }

    return stack.size();
  }

  // Helper class to store car data
  static class Car {

    int position;
    int speed;

    Car(int position, int speed) {
      this.position = position;
      this.speed = speed;
    }
  }
}