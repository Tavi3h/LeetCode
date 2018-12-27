package pers.tavish.solution.hard;

import java.util.Arrays;

import org.junit.Test;

/*

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             
for more information: https://leetcode.com/problems/candy/description/             
*/

public class Candy {
    
    // two array, two pass
    public int candy(int[] ratings) {
        int[] left2right = new int[ratings.length], right2left = new int[ratings.length];
        int res = 0;
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        // left -> right
        for (int i = 0; i < left2right.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                left2right[i + 1] = left2right[i] + 1;
            }
        }
        // right -> left
        for (int i = right2left.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right2left[i - 1] = right2left[i] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left2right[i], right2left[i]);
        }
        return res;
    }
    
/*
 *  One array, 2 pass
    public int candy(int[] ratings) {
        int res = 0, length = ratings.length;
        int[] nums = new int[length];
        Arrays.fill(nums, 1);

        // left -> right
        // //正向扫描一遍，如果右边的rating比左边高，那么右边的糖果数就比左边多一个
        for (int i = 0; i < length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }

        // right -> left
        // 反向扫描一遍，如果左边的rating比右边高，并且左边的糖果数比右边少，那么左边的糖果数应比右边多一
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }

        for (int i : nums) {
            res += i;
        }

        return res;
    }
 */

    @Test
    public void testCase() {
        int[] ratings = { 1, 2, 4, 3, 3, 1 };
        candy(ratings);
    }
}
