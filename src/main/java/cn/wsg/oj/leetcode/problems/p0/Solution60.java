package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence (HARD)
 *
 * @author Kingen
 * @see Solution31
 * @see Solution46
 * @see <a href="https://leetcode-cn.com/problems/permutation-sequence/">Permutation Sequence</a>
 */
public class Solution60 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String getPermutation(int n, int k) {
        k--;
        int factorial = 1;
        List<Integer> candidates = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            candidates.add(i);
        }
        StringBuilder builder = new StringBuilder(n);
        while (!candidates.isEmpty()) {
            factorial /= candidates.size();
            int i = k / factorial;
            builder.append(candidates.remove(i));
            k %= factorial;
        }
        return builder.toString();
    }
}
