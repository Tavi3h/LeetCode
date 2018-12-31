package pers.tavish.solution.medium;

import org.junit.Test;

import pers.tavish.struct.ListNode;

/*

Sort a linked list using insertion sort.

Algorithm of Insertion Sort:

    - Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
    - At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
    - It repeats until no input elements remain.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

for more information: https://leetcode.com/problems/insertion-sort-list/description/
*/

// 插入排序
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode nextNode = head.next;
            ListNode preNode = dummy;
            while (preNode.next != null && preNode.next.val < head.val) {
                preNode = preNode.next;
            }
            head.next = preNode.next;
            preNode.next = head;
            head = nextNode;
        }
        return dummy.next;
    }

    @Test
    public void testCase() {
        int[] arr = { 1, 3, 0, 4, 2 };
        ListNode head = ListNode.buildList(arr);
        System.out.println(head);
        System.out.println(insertionSortList(head));
    }
}
