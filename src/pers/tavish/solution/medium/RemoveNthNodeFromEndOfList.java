package pers.tavish.solution.medium;

import pers.tavish.struct.ListNode;

/*

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

for more information: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
*/

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        
        return dummy.next;
    }
}
