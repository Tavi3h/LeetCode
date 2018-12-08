package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

/*

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

for more information: https://leetcode.com/problems/unique-binary-search-trees-ii/description/
*/

public class UniqueBinarySearchTreesII {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new LinkedList<>() : generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (right < left) {
            res.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> lefts = generateTrees(left, i - 1), rights = generateTrees(i + 1, right);
                for (int j = 0; j < lefts.size(); j++) {
                    for (int k = 0; k < rights.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = lefts.get(j);
                        root.right = rights.get(k);
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
