package pers.tavish.solution.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:

    - Could you do it in O(n) time and O(1) space?

*/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode revHead = fast == null ? reverseList(slow) : reverseList(slow.next);
        
        System.out.println(revHead);
        
        while (revHead != null) {
            if (revHead.val != head.val) {
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = null;
        ListNode q = reverseList(p);
        p.next = head;
        return q;
    }

    @Test
    public void testCase() {
        assertEquals(false, isPalindrome(ListNode.buildList(1, 2, 3, 4, 5)));
        assertEquals(true, isPalindrome(ListNode.buildList(1, 2, 3, 2, 1)));
        assertEquals(true, isPalindrome(ListNode.buildList(1, 2, 2, 2, 1)));
        assertEquals(true, isPalindrome(ListNode.buildList(1, 2, 2, 1)));
        assertEquals(true, isPalindrome(ListNode.buildList(1, 1)));
        assertEquals(false, isPalindrome(ListNode.buildList(1, 2)));
        assertEquals(true, isPalindrome(ListNode.buildList(1)));
        assertEquals(false, isPalindrome(ListNode.buildList(1, 2, 2)));
    }

}
