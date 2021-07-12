package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution9;
import wsg.oj.java.leetcode.problems.p100.Solution125;

/**
 * 234. Palindrome Linked List (Easy)
 *
 * @author Kingen
 * @see Solution9
 * @see Solution125
 * @see Solution206
 * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">Palindrome Linked
 * List</a>
 * @since 2021-07-12
 */
class Solution234 extends Solution206 implements Solution {

    /**
     * Reverses the right half list and compares it with the left half.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        ListNode tail = reverseList(slow);
        while (tail != null && head != null) {
            if (tail.val != head.val) {
                return false;
            } else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }
}
