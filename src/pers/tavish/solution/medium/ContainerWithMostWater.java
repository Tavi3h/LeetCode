package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

for more information: https://leetcode.com/problems/container-with-most-water/description/
*/

public class ContainerWithMostWater {

    @Test
    public void testCase() {

        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE, i = 0, j = height.length - 1;

        while (j > i) {
            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
