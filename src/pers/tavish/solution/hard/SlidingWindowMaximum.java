package pers.tavish.solution.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
 
    - You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:

    - Could you solve it in linear time?

for more information: https://leetcode.com/problems/sliding-window-maximum/description/
*/

public class SlidingWindowMaximum {
    
    // O(N) ArrayDeque
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            deque.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
    
    // not O(N)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        if (nums == null || nums.length == 0) {
//            return new int[] {};
//        }
//
//        int[] res = new int[nums.length - k + 1];
//        int i = 0, j = k - 1;
//        while (j < nums.length) {
//            res[i] = getMax(i, j, nums);
//            ++i;
//            ++j;
//        }
//        return res;
//    }
//
//    private int getMax(int i, int j, int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int k = i; k <= j; k++) {
//            max = Math.max(max, nums[k]);
//        }
//        return max;
//    }
}
