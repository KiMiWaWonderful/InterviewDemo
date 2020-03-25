package com.company.leetcode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        //获取中间结点
        ListNode mid = getMiddle(head);
        //断开
        ListNode midNext = mid.next;
        mid.next = null;
        //排序，合并
        return mergeTwoLists(sortList(head), sortList(midNext));



    }

    /**
     * 实现合并两个已经排序的链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode first = l1.next, second = l2.next;
        ListNode res, newHead;
        if(l1.val < l2.val) {
            newHead = res = l1;
            second = l2;
        }else {
            newHead = res = l2;
            first = l1;
        }

        while (first != null || second != null) {
            if(first == null) {
                res.next = second;
                return newHead;
            }else if(second == null) {
                res.next = first;
                return newHead;
            } else if(first.val < second.val) {
                res.next = first;
                first = first.next;
                res = res.next;
            }else {
                res.next = second;
                second = second.next;
                res = res.next;
            }
        }
        return newHead;
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     * @param head
     * @return
     */
    private ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast, slow;
        fast = slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
