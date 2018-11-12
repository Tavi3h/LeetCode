package pers.tavish.solution.hard;

/*

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

for more information: https://leetcode.com/problems/merge-k-sorted-lists/description/
*/

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null) {
            return null;
        }
        
        return mergeKLists(lists, 0, lists.length - 1);
    }

    // 归并
    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {

        if (lo == hi) {
            return lists[lo];
        }
        
        if (lo > hi) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;

        ListNode l = mergeKLists(lists, lo, mid);
        ListNode r = mergeKLists(lists, mid + 1, hi);

        return mergeTwoLists(l, r);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }

        return dummy.next;
    }
}
