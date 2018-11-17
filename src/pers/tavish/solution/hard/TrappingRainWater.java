package pers.tavish.solution.hard;

import java.util.LinkedList;

/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

for more information: https://leetcode.com/problems/trapping-rain-water/description/
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0, current = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (current < height.length) {
            while (!list.isEmpty() && height[current] > height[list.peek()]) {
                int top = list.pop();
                if (list.isEmpty()) {
                    break;
                }
                int distance = current - list.peek() - 1;
                int bounded_height = Math.min(height[current], height[list.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            list.push(current++);
        }
        return ans;
    }
}
