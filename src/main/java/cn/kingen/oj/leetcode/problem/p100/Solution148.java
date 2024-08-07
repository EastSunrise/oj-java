package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/sort-list/">148. Sort List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution21
 * @see cn.kingen.oj.leetcode.problem.p0.Solution75
 * @see cn.kingen.oj.leetcode.problem.p100.Solution147
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.TWO_POINTERS, Tag.DIVIDE_AND_CONQUER, Tag.SORTING, Tag.MERGE_SORT},
        difficulty = Difficulty.MEDIUM
)
public class Solution148 {

    /**
     * Bottom-up merge sorting.
     */
    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode dummy = new ListNode(0, head);
        for (int sl = 1; sl < n; sl <<= 1) {
            ListNode p = dummy, t = dummy.next;
            while (t != null) {
                ListNode t1 = t, t2;
                int k1 = 1, k2 = 0;
                for (; k1 < sl && t.next != null; k1++) {
                    t = t.next;
                }
                t2 = t.next;
                for (; k2 < sl && t.next != null; k2++) {
                    t = t.next;
                }
                t = t.next;
                int i = 0, j = 0;
                while (i < k1 && j < k2) {
                    if (t1.val <= t2.val) {
                        p.next = t1;
                        t1 = t1.next;
                        i++;
                    } else {
                        p.next = t2;
                        t2 = t2.next;
                        j++;
                    }
                    p = p.next;
                }
                while (i < k1) {
                    p.next = t1;
                    t1 = t1.next;
                    p = p.next;
                    i++;
                }
                while (j < k2) {
                    p.next = t2;
                    t2 = t2.next;
                    p = p.next;
                    j++;
                }
            }
            p.next = null;
        }
        return dummy.next;
    }
}