package com.loltoulan.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode node1 = reverseBetween(node, 2, 4);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = m - 1;
        int end = n - 1;

        while (start < end) {
            Integer i = list.get(start);
            Integer j = list.get(end);
            list.set(start, j);
            list.set(end, i);
            start++;
            end--;
        }

        ListNode result = null;
        ListNode item = null;
        for (Integer integer : list) {
            if (result == null) {
                result = new ListNode(integer);
                item = result;
            }else{
                item.next = new ListNode(integer);
                item = item.next;
            }
        }
        return result;
    }

}
