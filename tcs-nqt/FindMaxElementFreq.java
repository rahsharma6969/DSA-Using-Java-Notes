import java.util.HashMap;

public class FindMaxElementFreq {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4};

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies (your code is correct)
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find max frequency element
        int maxFreq = 0;
        int maxElement = 0;  // Track the key with highest freq

        for (int key : map.keySet()) {  // Use keySet() to iterate keys [web:1]
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                maxElement = key;  // Update element (key), not keySet()
            }
        }

        System.out.println("Max element: " + maxElement + " (freq: " + maxFreq + ")");
        // Output: Max element: 3 (freq: 3)
    }
}
