package pers.tavish.solution.hard;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/*

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Example:
Input: [2,1,5,6,2,3]
Output: 10

for more information: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
*/

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }

    @Test
    public void testCase() {
        int[] heights = { 2, 3, 1, 4, 5, 3 };
        assertEquals(9, largestRectangleArea(heights));
    }
}
