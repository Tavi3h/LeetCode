package pers.tavish.solution.easy;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?

for more information: https://leetcode.com/problems/reverse-linked-list/
*/

public class ReverseLinkedList {
    
    // recursively, in-place
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head.next;
        head.next = null;
        ListNode q = reverseList(p);
        System.out.println(q.val + ":" + p.val);
        p.next = head;
        return q;
    }
    
    // iteratively, in-place
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode p = head, q = head.next;
//        p.next = null;
//        while (q != null) {
//            ListNode tmp = q.next;
//            q.next = p;
//            p = q;
//            q = tmp;
//        }
//        return p;
//    }

    @Test
    public void testCase() {
        reverseList(ListNode.buildList(1, 2, 3, 4));
    }
}
