package PriorityQueue;

import java.util.Map;

/*
347. Top K Frequent Elements
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

  */
import java.util.PriorityQueue;
import java.util.HashMap;


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for(int num : frequencyMap.keySet()) {
            minHeap.add(num);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

    }
}
public class TopKfreqElements {
    
}
