package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

for more information: https://leetcode.com/problems/partition-list/description/
*/

public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next != null ? val + " -> " + next.toString() : val + "";
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode stub = dummy;

        while (stub != null) {
            if (stub.next != null && stub.next.val >= x) {
                break;
            }
            stub = stub.next;
        }

        ListNode curr = stub;
        while (curr != null) {
            if (curr.next != null && curr.next.val < x) {
                ListNode tmp = curr.next;
                curr.next = tmp.next;
                tmp.next = stub.next;
                stub.next = tmp;
                stub = stub.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void testCase() {

        int[] nums = { 1, 0, 6, 1, 4, 3, 2, 5, 2 };
        System.out.println("createList :" + createList(nums));
        System.out.println(partition(createList(nums), 3));

    }

    private ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode head = dummy;
        for (int i : nums) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dummy.next;
    }
}
