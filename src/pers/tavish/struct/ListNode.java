package pers.tavish.struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return next != null ? val + "->" + next.toString() : val + "";
    }
    
    public static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(-1), curr = dummy;
        for (int i : vals) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }
}