package com.shuzijun.leetcode;

/**

 */
public  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(val);
        if(next!=null){
            sb.append("->").append(next);
        }
        return sb.toString();
    }
}
