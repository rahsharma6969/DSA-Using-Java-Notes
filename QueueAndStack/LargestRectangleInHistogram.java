/*84. Largest Rectangle in Histogram
Hard
Topics
premium lock icon
Companies
Given an array of integers heights representing the histogram's bar 
height where the width of each bar is 1, return the area of the largest rectangle in the histogram.


Input: heights = [2,1,5,6,2,3]
Output: 10
  */

import java.utils.*;
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        // previous smaller element index
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // next smaller element index
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
public class LargestRectangleInHistogram {
    
}
