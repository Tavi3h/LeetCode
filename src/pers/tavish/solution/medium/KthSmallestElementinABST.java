package pers.tavish.solution.medium;

import pers.tavish.struct.TreeNode;

/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 

    - You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:

    - What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

for more information: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

public class KthSmallestElementinABST {
    
    // divide and conquer
    public int kthSmallest(TreeNode root, int k) {
        int cnt = count(root.left);
        return k <= cnt ? kthSmallest(root.left, k)
                : (k > cnt + 1 ? kthSmallest(root.right, k - cnt - 1) : root.val);
    }

    private int count(TreeNode node) {
        return node == null ? 0 : count(node.left) + count(node.right) + 1;
    }
    
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> inOrder = new ArrayList<>();
//        inOrderTraversal(root, inOrder);
//        return inOrder.get(k - 1);
//    }
//
//    private void inOrderTraversal(TreeNode node, List<Integer> inOrder) {
//        if (node == null) {
//            return;
//        }
//        inOrderTraversal(node.left, inOrder);
//        inOrder.add(node.val);
//        inOrderTraversal(node.right, inOrder);
//    }
}
