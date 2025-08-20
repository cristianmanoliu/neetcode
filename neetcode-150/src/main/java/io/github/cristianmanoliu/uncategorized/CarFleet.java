package io.github.cristianmanoliu.uncategorized;

// https://neetcode.io/problems/car-fleet?list=neetcode150
public class CarFleet {
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cars = new double[n][2];
    for (int i = 0; i < n; i++) {
      // Store the position and the time it takes for each car to reach the target
      cars[i][0] = position[i];
      // Calculate the time it takes for each car to reach the target
      cars[i][1] = (double) (target - position[i]) / speed[i];
    }
    // Sort cars by position in descending order
    java.util.Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
    int fleets = 0;
    double lastTime = 0;
    for (int i = 0; i < n; i++) {
      // If the current car arrives later than the last car in the fleet, it forms a new fleet
      if (cars[i][1] > lastTime) {
        // Increment the fleet count
        fleets++;
        // Update the last time to the current car's time
        lastTime = cars[i][1];
      }
    }
    return fleets;
  }
}
