package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution9
 * @see cn.kingen.oj.leetcode.problem.p100.Solution125
 * @see cn.kingen.oj.leetcode.problem.p200.Solution206
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2130
 */
@Question(tags = {Tag.STACK, Tag.RECURSION, Tag.LINKED_LIST, Tag.TWO_POINTERS}, difficulty = Difficulty.EASY)
public class Solution234 {

    /**
     * Reverses the left half and then compares the two halves.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isPalindrome(ListNode head) {
        // p is right half and q is left half(reversed)
        ListNode p = head, t = head, q = null, tmp;
        while (t != null && t.next != null) {
            t = t.next.next;
            tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        if (t != null) { // odd length
            p = p.next;
        }
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

}