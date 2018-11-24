package com.shuzijun.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 */
public class RemoveNthNodeFromEndofList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node =new ListNode(head.val) ;
            node.next = head;
            ListNode thisN = node;
            ListNode thisR = node;
            int i=1;
            while (thisN.next !=null){
                thisN=thisN.next;
                if(i>n){
                    thisR = thisR.next;
                }

                i++;
            }
            thisR.next = thisR.next.next;
            return node.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
