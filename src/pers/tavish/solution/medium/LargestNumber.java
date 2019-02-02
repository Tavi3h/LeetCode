package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.

for more information: https://leetcode.com/problems/largest-number/description/
*/

public class LargestNumber {
    public String largestNumber(int[] nums) {
        Long[] longs = new Long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longs[i] = (long) nums[i];
        }
        Arrays.sort(longs, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (Long.parseLong(o1 + "" + o2) - Long.parseLong(o2 + "" + o1));
            }
        });
        if (longs[longs.length - 1] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = longs.length - 1; i >= 0; i--) {
            sb.append(longs[i]);
        }
        return sb.toString();
    }

    @Test
    public void testCase() {
        int[] nums = { 3, 30, 34, 5, 9 };
        assertEquals(largestNumber(nums), "9534330");
    }
}
