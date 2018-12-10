package pers.tavish.solution.hard;

/*

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2

Example 2:
Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

for more information: https://leetcode.com/problems/recover-binary-search-tree/description/
*/

public class RecoverBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre, first, second;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null && pre.val > node.val) {
            if (first == null) {
                first = pre;
            }
            second = node;
        }
        pre = node;
        inOrder(node.right);
    }
}
