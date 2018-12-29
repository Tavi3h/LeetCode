package pers.tavish.solution.hard;

import java.util.LinkedList;
import java.util.List;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
*/

// 后序遍历：左-右-中
public class BinaryTreePostorderTraversal {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>(); 
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            res.addFirst(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        return res;
    }
    
/*
 * recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
    }
 */
}
