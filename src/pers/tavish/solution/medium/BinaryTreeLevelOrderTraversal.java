package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

for more information: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
*/

// BFS
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(new LinkedList<>(tmp));
        }
        return res;
    }
}
