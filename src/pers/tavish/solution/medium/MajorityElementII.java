package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:
Input: [3,2,3]
Output: [3]

Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

for more information: https://leetcode.com/problems/majority-element-ii/
*/

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        for (int n : nums) {
            if (major1 == n) {
                count1++;
            } else if (major2 == n) {
                count2++;
            } else if (count1 == 0) {
                major1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                major2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (n == major1) {
                count1++;
            } else if (n == major2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(major1);
        }
        if (count2 > nums.length / 3) {
            list.add(major2);
        }

        return list;
    }
}
