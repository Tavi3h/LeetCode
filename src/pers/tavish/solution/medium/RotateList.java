package pers.tavish.solution.medium;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

*/

public class RotateList {


    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tmp = head;
        int length = 1;
        while (tmp.next != null) {
            ++length;
            tmp = tmp.next;
        }

        if (k % length == 0) {
            return head;
        }

        if (k > length) {
            k %= length;
        }

        ListNode tail = tmp;
        tmp = head;
        for (int i = 0; i < length - 1 - k; i++) {
            tmp = tmp.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = tmp.next;
        tmp.next = null;
        tail.next = head;

        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(rotateRight(node1, 10));
    }
}
