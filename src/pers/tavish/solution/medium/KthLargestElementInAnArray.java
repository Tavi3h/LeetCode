package pers.tavish.solution.medium;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/*

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

for more information: https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

public class KthLargestElementInAnArray {
    
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    
    @Test
    public void testCase() {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        findKthLargest(nums, 4);
    }
    
    // Sort
//    public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         return nums[nums.length - k];
//    }
}
