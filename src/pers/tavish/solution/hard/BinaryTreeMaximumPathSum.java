package pers.tavish.solution.hard;

/*

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
*/

public class BinaryTreeMaximumPathSum {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = { Integer.MIN_VALUE };
        maxPathSum(root, res);
        return res[0];
    }

    private int maxPathSum(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left, res), right = maxPathSum(root.right, res);
        int curr = root.val + Math.max(left, 0) + Math.max(right, 0);
        res[0] = Math.max(res[0], curr);
        return root.val + Math.max(left, Math.max(right, 0));
    }

}
