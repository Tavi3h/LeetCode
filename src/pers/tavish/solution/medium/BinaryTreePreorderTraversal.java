package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
*/

// 前序遍历：中-左-右
public class BinaryTreePreorderTraversal {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            res.add(node.val);
            if (node.right != null) {
                list.add(node.right);
            }
            if (node.left != null) {
                list.add(node.left);
            }
        }
        return res;
    }
    
/*
 * recursive 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }
 */
}
