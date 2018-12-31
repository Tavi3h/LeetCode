package pers.tavish.solution.medium;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

for more information: https://leetcode.com/problems/sort-list/description/
*/

public class SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        head = sortList(head);
        slow = sortList(slow);
        return mergeTwoLists(head, slow);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE), curr = dummy;
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
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    @Test
    public void testCase() {
        int[] vals = { 3, 2, 4, 1, 9, 5 };
        ListNode head = ListNode.buildList(vals);
        System.out.println(sortList(head));
    }
}
