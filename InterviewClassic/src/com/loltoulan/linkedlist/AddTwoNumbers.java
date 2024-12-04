package com.loltoulan.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean carry = false;

        ListNode result = null;
        ListNode item = null;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (carry) {
                sum += 1;
            }
            if (l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (sum >= 10) {
                carry = true;
                sum = sum - 10;
            } else {
                carry = false;
            }
            if (result == null) {
                result = new ListNode(sum);
                item = result;
            }else{
                item.next = new ListNode(sum);
                item = item.next;
            }

        }
        if (carry) {
            item.next = new ListNode(1);
        }
        return result;
    }
}
