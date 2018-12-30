package pers.tavish.solution.medium;

import java.math.BigInteger;

import pers.tavish.struct.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

for more information: https://leetcode.com/problems/add-two-numbers/description/
*/

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        char[] result = convert(l1).add(convert(l2)).toString().toCharArray();
        
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        for (int i = result.length - 1; i >= 0; i--) {
            curr.next = new ListNode(result[i] - '0');
            curr = curr.next;
        }

        return dummyHead.next;
    }

    private BigInteger convert(ListNode listNode) {

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(listNode.val);
            if (listNode.next == null) {
                break;
            } else {
                listNode = listNode.next;
            }
        }

        return new BigInteger(sb.reverse().toString());
    }
}
