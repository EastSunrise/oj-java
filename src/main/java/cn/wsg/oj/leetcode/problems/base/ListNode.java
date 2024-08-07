package cn.wsg.oj.leetcode.problems.base;

/**
 * Definition for singly-linked list.
 * <p>
 * Use {@link cn.kingen.oj.leetcode.support.ListNode} instead.
 */
@Deprecated(forRemoval = true)
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
