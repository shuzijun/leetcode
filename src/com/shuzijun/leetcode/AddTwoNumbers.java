package com.shuzijun.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrying = 0;
        ListNode returnListNode = null;
        ListNode thisListNode = null;
        while (l1 != null || l2 != null || carrying != 0) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = val1 + val2 + carrying;
            if (returnListNode == null) {
                returnListNode = new ListNode(val % 10);
                thisListNode = returnListNode;
            } else {
                ListNode nextListNode = new ListNode(val % 10);
                thisListNode.next = nextListNode;
                thisListNode = nextListNode;

            }
            carrying = val / 10;

        }
        return returnListNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}