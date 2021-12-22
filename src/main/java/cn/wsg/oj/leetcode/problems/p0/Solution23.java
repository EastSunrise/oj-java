package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution264;

/**
 * 23. Merge k Sorted Lists (HARD)
 *
 * @author Kingen
 * @see Solution21
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class Solution23 implements Solution {

    /**
     * @complexity T=O(L*log{n}), n=len(lists), l=the total length of all lists
     * @complexity S=O(log{n})
     * @see #DIVIDE_AND_CONQUER
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int fromIn, int toEx) {
        if (toEx - fromIn == 1) {
            return lists[fromIn];
        }
        int mid = (fromIn + toEx) / 2;
        ListNode left = mergeLists(lists, fromIn, mid);
        ListNode right = mergeLists(lists, mid, toEx);
        ListNode res = new ListNode(-1, left), prev = res;
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
        return res.next;
    }
}
