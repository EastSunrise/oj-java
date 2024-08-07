package cn.kingen.oj.leetcode.support;

/**
 * Definition for singly-linked list.
 */
public class ListNode {

    public final int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                " ,next=" + (next == null ? "null" : next.val) +
                '}';
    }
}
