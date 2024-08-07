package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution21
 * @see cn.kingen.oj.leetcode.problem.p200.Solution264
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.DIVIDE_AND_CONQUER, Tag.HEAP_PRIORITY_QUEUE, Tag.MERGE_SORT},
        difficulty = Difficulty.HARD
)
public class Solution23 {

    @Complexity(time = "O(kn*log{k})", space = "O(log{k})", note = "k is the number of lists, n is average length of lists")
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int from, int to) {
        if (from == to) {
            return lists[from];
        }
        int mid = (from + to) / 2;
        ListNode left = mergeLists(lists, from, mid);
        ListNode right = mergeLists(lists, mid + 1, to);
        ListNode head = new ListNode(-1, left), prev = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = left;
                prev = prev.next;
                left = left.next;
            } else {
                prev.next = right;
                prev = prev.next;
                right = right.next;
            }
        }
        if (left != null) {
            prev.next = left;
        } else {
            prev.next = right;
        }
        return head.next;
    }
}