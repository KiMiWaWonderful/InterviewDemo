package com.company.linkedList.test;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

//        System.out.println(827/10);//82
//        System.out.println(827%10);//7

        ListNode listNode = addTwoNumbers(l1,l4);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;

            //查看是否有进位
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);//求余
            curr = curr.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        //每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
