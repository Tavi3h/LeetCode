package pers.tavish.solution.medium;

/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

for more information: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
*/

public class ConvertSortedListToBinarySearchTree {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next != null ? val + "->" + next.toString() : val + "";
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // slow/fast pointer, O(NlogN)
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {

        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        for (ListNode fast = head; fast != tail && tail != fast.next; fast = fast.next.next) {
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
    
/*
 * convert List to List(JDK) first, O(N)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) >> 1;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, lo, mid - 1);
        root.right = sortedListToBST(list, mid + 1, hi);
        return root;
    }


*/
}
