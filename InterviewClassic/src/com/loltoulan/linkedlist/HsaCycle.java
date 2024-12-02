package com.loltoulan.linkedlist;

public class HsaCycle {

    public static void main(String[] args) {
        ListNode1 node = new ListNode1(1);
        node.next = null;
        System.out.println(hasCycle(node));
    }


    public static boolean hasCycle(ListNode1 head) {
        if (head == null) {
            return false;
        }
        ListNode1 slow = head;
        ListNode1 fast = head;
        if (fast.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}


class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}
