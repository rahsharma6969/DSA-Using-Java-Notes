
class Solution {

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int dayCount = 1; // Start with the first day

        for (int weight : weights) {
            if (weight > capacity) {
                return false; // If any single weight exceeds capacity, it's impossible to ship
            }
            if (currentLoad + weight > capacity) {
                dayCount++; // Move to the next day
                currentLoad = weight; // Start loading the next day with the current weight
            } else {
                currentLoad += weight; // Continue loading the current day
            }
        }
        return dayCount <= days; // Check if we can ship within the given days
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight); // The minimum capacity must be at least the heaviest weight
            high += weight; // The maximum capacity is the sum of all weights
        }
        while (low < high) {
            int mid = low + (high - low) / 2; // Calculate the midpoint capacity
            if (canShip(weights, days, mid)) {
                high = mid; // If we can ship with this capacity, try a smaller one
            } else {
                low = mid + 1; // If we can't ship, we need a larger capacity
            }
        }
        return low; // The minimum capacity needed to ship within the given days

    }
}
public class CapacityToShip {
    
}
