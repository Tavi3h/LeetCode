package pers.tavish.solution.medium;

/*

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

for more information: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
*/

public class FlattenBinaryTreeToLinkedList {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        root = flatten(root, null);
    }

    private TreeNode flatten(TreeNode node, TreeNode next) {
        
        if (node == null) {
            return next;
        }

        next = flatten(node.right, next);
        next = flatten(node.left, next);
        node.right = next;
        node.left = null;

        return node;
    }
/*
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }

        List<TreeNode> preOrder = new ArrayList<>();
        getPreOrder(root, preOrder);
        TreeNode dummy = new TreeNode(-1);
        root = preOrder.get(0);
        dummy.left = root;
        for (int i = 1; i < preOrder.size(); ++i) {
            root.left = null;
            root.right = preOrder.get(i);
            root = root.right;
        }
        root.left = null;
        root.right = null;
        root = dummy.left;
    }

    private void getPreOrder(TreeNode node, List<TreeNode> preOrder) {
        if (node == null) {
            return;
        }
        preOrder.add(node);
        getPreOrder(node.left, preOrder);
        getPreOrder(node.right, preOrder);
    }
*/
}
