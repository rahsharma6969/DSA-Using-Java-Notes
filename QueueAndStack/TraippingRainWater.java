/*
42. Trapping Rain Water
Hard
Topics
premium lock icon
Companies
Given n non-negative integers representing an 
elevation map where the width of each bar is 1, compute how much water it can trap after raining. */


import java.util.Stack;


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for(int i=0; i<n; i++) {

            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top= stack.pop();
                if(stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int minHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += width * minHeight;
            }

            stack.push(i);
        }
        return water;
    }
}