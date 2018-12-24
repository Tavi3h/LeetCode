package pers.tavish.solution.easy;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3

for more information: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
*/

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            if (curr == null || curr.val != head.val) {
                head.next = curr;
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    @Test
    public void testCase() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);
        System.out.println(deleteDuplicates(node1));
    }
}
