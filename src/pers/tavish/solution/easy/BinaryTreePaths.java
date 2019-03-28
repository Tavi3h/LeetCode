package pers.tavish.solution.easy;

import java.util.ArrayList;
import java.util.List;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

for more information: https://leetcode.com/problems/binary-tree-paths/description/
*/

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            binaryTreePaths(root, res, "");
        }
        return res;
    }

    private void binaryTreePaths(TreeNode node, List<String> res, String s) {
        
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            res.add(s + node.val);
            return;
        }
        binaryTreePaths(node.left, res, s + node.val + "->");
        binaryTreePaths(node.right, res, s + node.val + "->");
    }
    
}
