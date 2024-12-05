package com.loltoulan.linkedlist;

public class LinkedListPartition {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
//        ListNode newHead = partition(head, 3);
//        while (newHead != null) {
//            System.out.println(newHead.val);
//            newHead = newHead.next;
//        }

        ListNode head = new ListNode(1);
        ListNode newHead = partition(head, 0);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    // 两次while循环
    public static ListNode partition1(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0, head);
        ListNode bigDummy = new ListNode(0, head);

        ListNode newHead = null;
        ListNode newTail = null;

        while (smallDummy.next != null) {
            if (smallDummy.next.val < x) {
                if (newHead == null) {
                    newHead = new ListNode(smallDummy.next.val);
                    newTail = newHead;
                } else {
                    newTail.next = new ListNode(smallDummy.next.val);
                    newTail = newTail.next;
                }
            }
            smallDummy = smallDummy.next;
        }
        if (newTail == null) {
            return head;
        }
        while (bigDummy.next != null) {
            if (bigDummy.next.val >= x) {
                newTail.next = new ListNode(bigDummy.next.val);
                newTail = newTail.next;
            }
            bigDummy = bigDummy.next;
        }
        return newHead;
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(0, head);

        ListNode smallHead = null;
        ListNode smallTail = null;

        ListNode bigHead = null;
        ListNode bigTail = null;

        while (dummy.next != null) {
            if (dummy.next.val < x) {
                if (smallHead == null) {
                    smallHead = new ListNode(dummy.next.val);
                    smallTail = smallHead;
                } else {
                    smallTail.next = new ListNode(dummy.next.val);
                    smallTail = smallTail.next;
                }
            }else {
                if (bigHead == null) {
                    bigHead = new ListNode(dummy.next.val);
                    bigTail = bigHead;
                } else {
                    bigTail.next = new ListNode(dummy.next.val);
                    bigTail = bigTail.next;
                }
            }
            dummy = dummy.next;
        }
        if (smallHead == null || bigHead == null) {
            return head;
        }
        smallTail.next = bigHead;
        return smallHead;
    }
}
