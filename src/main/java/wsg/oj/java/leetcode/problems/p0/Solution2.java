package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution371;
import wsg.oj.java.leetcode.problems.p400.Solution415;
import wsg.oj.java.leetcode.problems.p400.Solution445;
import wsg.oj.java.leetcode.problems.p900.Solution989;

/**
 * 2. Add Two Numbers (Medium)
 *
 * @author Kingen
 * @see Solution43
 * @see Solution67
 * @see Solution371
 * @see Solution415
 * @see Solution445
 * @see Solution989
 * @see Solution1634
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">Add Two Numbers</a>
 * @since 2021-07-10
 */
public class Solution2 implements Solution {

    /**
     * Traverses the two lists with a carry.
     *
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), p = res;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            int sum = l1.val + +carry;
            l1 = l1.next;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return res.next;
    }
}
