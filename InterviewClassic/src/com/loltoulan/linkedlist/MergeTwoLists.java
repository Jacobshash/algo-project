package com.loltoulan.linkedlist;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode item = null;
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        while (true) {
            if (l1 == null) {
                item.next = l2;
                return result;
            }
            if (l2 == null) {
                item.next = l1;
                return result;
            }
            int l1val = l1.val;
            int l2val = l2.val;
            if (l1val <= l2val) {
                if (result == null) {
                    result = item = new ListNode(l1val);
                }else {
                    item.next = new ListNode(l1val);
                    item = item.next;
                }
                l1 = l1.next;
            }else {
                if (result == null) {
                    result = item = new ListNode(l2val);
                }else {
                    item.next = new ListNode(l2val);
                    item = item.next;
                }
                l2 = l2.next;
            }
        }
    }

}
