package pers.tavish.solution.medium;

import pers.tavish.struct.TreeNode;

/*

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
    
    - In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

for more information: https://leetcode.com/problems/count-complete-tree-nodes/
*/

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
