package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/add-to-array-form-of-integer/">989. Add to Array-Form of Integer</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 * @see cn.kingen.oj.leetcode.problem.p0.Solution66
 * @see cn.kingen.oj.leetcode.problem.p0.Solution67
 * @see cn.kingen.oj.leetcode.problem.p400.Solution415
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution989 {

    @Complexity(time = "O(n+log{k})", space = "O(max{n,log{k}})")
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>(num.length + 1);
        int i = num.length - 1, carry = 0;
        while (i >= 0 && k > 0) {
            int sum = num[i] + k % 10 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            i--;
            k /= 10;
        }
        while (i >= 0) {
            int sum = num[i] + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (k > 0) {
            int sum = k % 10 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        if (carry == 1) {
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans;
    }
}