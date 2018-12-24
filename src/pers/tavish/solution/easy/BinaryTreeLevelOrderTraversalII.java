package pers.tavish.solution.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pers.tavish.struct.TreeNode;


/*

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

for more information: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
*/

public class BinaryTreeLevelOrderTraversalII {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<>();

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
            res.addFirst(new LinkedList<>(tmp));
        }
        return res;
    }

}
