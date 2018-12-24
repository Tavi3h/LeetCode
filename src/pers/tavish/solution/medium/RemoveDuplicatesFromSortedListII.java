package pers.tavish.solution.medium;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:
Input: 1->1->1->2->3
Output: 2->3

for more information: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
*/

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), tmp = dummy, curr = head;
        int cnt = 1;
        while (curr != null) {
            curr = curr.next;
            if (curr != null && curr.val == head.val) {
                ++cnt;
            } else {
                if (cnt > 1) {
                    cnt = 1;
                } else {
                    tmp.next = head;
                    tmp = tmp.next;
                }
                head = curr;
            }
        }
        tmp.next = null;
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(1);
        // ListNode node3 = new ListNode(2);
        // ListNode node4 = new ListNode(3);
        // ListNode node5 = new ListNode(3);
        // ListNode node6 = new ListNode(4);
        // ListNode node7 = new ListNode(4);
        // ListNode node8 = new ListNode(5);
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // node5.next = node6;
        // node6.next = node7;
        // node7.next = node8;
        System.out.println(node1);
        System.out.println(deleteDuplicates(node1));
    }
}
