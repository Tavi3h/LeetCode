package pers.tavish.solution.medium;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Given a linked list, swap every two adjacent nodes and return its head.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

for more information: https://leetcode.com/problems/swap-nodes-in-pairs/description/
*/

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode curr = dummy;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(2);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);
        swapPairs(dummy.next);
    }
}
