package pers.tavish.solution.easy;

/*

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
Input: [3,0,1]
Output: 2

Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:

    - Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

for more information: https://leetcode.com/problems/missing-number/description/
*/

public class MissingNumber {
    
    // O(1) space
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
    
    // O(N) space
//    public int missingNumber(int[] nums) {
//        int[] helper = new int[nums.length];
//        Arrays.fill(helper, -1);
//        for (int i = 0; i < nums.length; i++) {
//            helper[nums[i]] = 0;
//        }
//        for (int i = 0; i < helper.length; i++) {
//            if (helper[i] == -1) {
//                return i;
//            }
//        }
//        return 0;
//    }
}
