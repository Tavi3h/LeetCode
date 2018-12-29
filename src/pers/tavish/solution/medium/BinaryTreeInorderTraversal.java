package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import pers.tavish.struct.TreeNode;

/*
 * 
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

For more information: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
*/

// 中序遍历：左-中-右
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode curr = root;
        while (!list.isEmpty() || curr != null) {
            while (curr != null) {
                list.addFirst(curr);
                curr = curr.left;
            }
            curr = list.removeFirst();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    } 
}
/*
 * recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, res);
        res.add(node.val);
        inorderTraversal(node.right, res);
    }
*/
