package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]

Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

for more information: https://leetcode.com/problems/binary-tree-right-side-view/
*/

public class BinaryTreeRightSideView {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode node = null;
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(node.val); // store the last element of each level
            }
        }
        return res;
    }
}
