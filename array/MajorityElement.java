import java.util.*;
public class MajorityElement {

    // Boyer-Moore Voting Algorithm
    static int majority(int[] arr) {
        int count = 0;
        int candidate = -1;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is actually the majority element
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element
        }
    }

    // Using hashing

    static int majorityHashing(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(arr[num], map.getOrDefault(arr[num],0)+1);
            
        }
        for(int key : map.keySet()){
            if(map.get(key) > arr.length/2){
                return key;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element (Boyer-Moore): " + majority(arr));  // time complexity O(n) space complexity O(1)
        System.out.println("Majority Element (Hashing): " + majorityHashing(arr)); // time complexity O(n) space complexity O(n)
        
    }
}
