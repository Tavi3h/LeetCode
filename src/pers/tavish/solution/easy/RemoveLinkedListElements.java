package pers.tavish.solution.easy;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

for more information: https://leetcode.com/problems/remove-linked-list-elements/
*/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void testCase() {
        System.out.println(removeElements(ListNode.buildList(1, 1, 1, 1, 1, 1, 1), 1));
    }
}
