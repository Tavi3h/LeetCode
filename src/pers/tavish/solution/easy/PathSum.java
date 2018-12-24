package pers.tavish.solution.easy;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

for more information: https://leetcode.com/problems/path-sum/description/
*/

public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode node, int sum, int nodeSum) {

        if (node == null) {
            return false;
        }

        nodeSum += node.val;

        return node.left == null && node.right == null ? nodeSum == sum
                : hasPathSum(node.left, sum, nodeSum) || hasPathSum(node.right, sum, nodeSum);
    }

/*
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null) {
            return false;
        }

        sum -= root.val;

        return root.left == null && root.right == null ? sum == 0
                : hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }
*/    
}
