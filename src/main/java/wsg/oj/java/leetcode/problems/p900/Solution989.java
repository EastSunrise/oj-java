package wsg.oj.java.leetcode.problems.p900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution2;
import wsg.oj.java.leetcode.problems.p0.Solution66;
import wsg.oj.java.leetcode.problems.p0.Solution67;
import wsg.oj.java.leetcode.problems.p400.Solution415;

/**
 * 989. Add to Array-Form of Integer (EASY)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution66
 * @see Solution67
 * @see Solution415
 * @see <a href="https://leetcode-cn.com/problems/add-to-array-form-of-integer/">Add to Array-Form
 * of Integer</a>
 * @since 2021-07-27
 */
public class Solution989 implements Solution {

    /**
     * @complexity T=O(n+m), n=the length of num, m=log_{10}{k}
     * @complexity S=O(max(n,m))
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>(num.length + 1);
        int i = num.length - 1, carry = 0;
        while (i >= 0 && k > 0) {
            int sum = num[i] + k % 10 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            i--;
            k /= 10;
        }
        while (i >= 0) {
            int sum = num[i] + carry;
            res.add(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (k > 0) {
            int sum = k % 10 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        if (carry == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }
}
