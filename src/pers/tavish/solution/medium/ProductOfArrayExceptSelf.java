package pers.tavish.solution.medium;

/*

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:

    - Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

fore more information: https://leetcode.com/problems/product-of-array-except-self/description/
*/

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 1; i < leftProduct.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[rightProduct.length - 1] = 1;
        for (int i = rightProduct.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }
        
        return res;
    }
}
