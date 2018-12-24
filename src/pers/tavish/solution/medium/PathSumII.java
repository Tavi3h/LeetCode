package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import pers.tavish.struct.TreeNode;

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

for more information: https://leetcode.com/problems/path-sum-ii/description/
*/

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            pathSum(root, sum, 0, res, new LinkedList<>());
        }
        return res;
    }

    private void pathSum(TreeNode node, int sum, int nodeSum, List<List<Integer>> res, LinkedList<Integer> linkedList) {

        if (node == null) {
            return;
        }

        nodeSum += node.val;
        linkedList.add(node.val);

        if (node.left == null && node.right == null && nodeSum == sum) {
            res.add(new LinkedList<>(linkedList));
        }
        pathSum(node.left, sum, nodeSum, res, linkedList);
        pathSum(node.right, sum, nodeSum, res, linkedList);
        linkedList.removeLast();
    }

    @Test
    public void testCase() {
        int[] preorder = { 5, 4, 11, 7, 2, 8, 13, 4, 5, 1 }, inorder = { 7, 11, 2, 4, 5, 13, 8, 5, 4, 1 };
        System.out.println(pathSum(buildTree(preorder, inorder), 22));
    }

    // build tree
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart], rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
