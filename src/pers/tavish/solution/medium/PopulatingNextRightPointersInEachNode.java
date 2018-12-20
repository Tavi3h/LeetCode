package pers.tavish.solution.medium;

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

    - You may only use constant extra space.
    - Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    - You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

for more information: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
*/

public class PopulatingNextRightPointersInEachNode {

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        public TreeLinkNode(int x) {
            val = x;
        }
    }

    // recursive
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        // According to the note, if root.left exists (not null), so does root.right.
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
/*
 * Level Order Traversal
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode t = queue.poll();
                if (i < size - 1) {
                    t.next = queue.peek();
                }
                // According to the note, if root.left exists (not null), so does root.right.
                if (t.left != null) {
                    queue.add(t.left);
                    queue.add(t.right);
                }
            }
        }
    }
*/
}