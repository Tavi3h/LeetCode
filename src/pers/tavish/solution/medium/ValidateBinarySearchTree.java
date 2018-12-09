package pers.tavish.solution.medium;

/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

for more information: https://leetcode.com/problems/validate-binary-search-tree/description/
*/

public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return root == null ? true : isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long lo, long hi) {

        return node == null ? true
                : node.val <= lo || node.val >= hi ? false
                        : isValid(node.left, lo, node.val) && isValid(node.right, node.val, hi);
    }

}
/*
    public boolean isValidBST(TreeNode root) {
        return root == null ? true
                : isValid(root.left, Long.MIN_VALUE, root.val) && isValid(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        return node == null ? true
                : node.val <= min || node.val >= max ? false
                        : isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

*/