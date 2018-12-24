package pers.tavish.solution.medium;

import pers.tavish.struct.TreeLinkNode;

/*

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

for more information: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
*/

public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode node = root.next;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            }
            if (node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }
        if (root.right != null) {
            root.right.next = node;
        }
        if (root.left != null) {
            root.left.next = root.right == null ? node : root.right;
        }
        connect(root.right);
        connect(root.left);
    }
}
