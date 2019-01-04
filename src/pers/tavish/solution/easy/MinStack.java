package pers.tavish.solution.easy;

import java.util.NoSuchElementException;

import org.junit.Test;

/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    - push(x) -- Push element x onto stack.
    - pop() -- Removes the element on top of the stack.
    - top() -- Get the top element.
    - getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

public class MinStack {

    private ListNode beginMaker, endMaker;

    private int min;

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public MinStack() {
        beginMaker = new ListNode(Integer.MIN_VALUE);
        endMaker = new ListNode(Integer.MAX_VALUE);
        beginMaker.next = endMaker;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = beginMaker.next;
        beginMaker.next = node;
        min = Math.min(x, min);
    }

    public void pop() {
        check();
        boolean popMin = min == beginMaker.next.val;
        beginMaker.next = beginMaker.next.next;
        if (popMin) {
            min = Integer.MAX_VALUE;
            ListNode curr = beginMaker.next;
            while (curr != endMaker) {
                min = Math.min(curr.val, min);
                curr = curr.next;
            }
        }
    }

    public int top() {
        check();
        return beginMaker.next.val;
    }

    public int getMin() {
        check();
        return min;
    }
    
    private void check() {
        if (beginMaker.next == endMaker) {
            throw new NoSuchElementException();
        }
    }

    @Test
    public void testCase() {
        MinStack stack = new MinStack();
        stack.push(-2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
