package com.loltoulan.linkedlist;

public class RotateRight {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        ListNode node = rotateRight(node1, 2);
        System.out.println("===================");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = getLength(new ListNode(0, head)) - 1;
        // 将链表转为环形链表
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
        }
        iter.next = head;
        for (int i = 0; i <  n - k % n; i++) {
            iter = iter.next;
        }
        ListNode newHead = iter.next;
        iter.next = null;
        return newHead;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

}
