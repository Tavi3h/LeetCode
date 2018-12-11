package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

for more information: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
*/

public class BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedlist = new LinkedList<>();
        
        linkedlist.add(root);

        int level = 1;
        while (!linkedlist.isEmpty()) {
            int size = linkedlist.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = null;
                if (level % 2 != 0) {
                    node = linkedlist.removeFirst();
                    if (node.left != null) {
                        linkedlist.addLast(node.left);
                    }
                    if (node.right != null) {
                        linkedlist.addLast(node.right);
                    }
                } else {
                    node = linkedlist.removeLast();
                    if (node.right != null) {
                        linkedlist.addFirst(node.right);
                    }
                    if (node.left != null) {
                        linkedlist.addFirst(node.left);
                    }
                }
                tmp.add(node.val);
            }
            ++level;
            res.add(new LinkedList<>(tmp));
        }
        return res;
    }
}
