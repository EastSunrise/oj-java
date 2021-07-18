package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 60. Permutation Sequence (HARD)
 *
 * @author Kingen
 * @see Solution31
 * @see Solution46
 * @see <a href="https://leetcode-cn.com/problems/permutation-sequence/">Permutation Sequence</a>
 * @since 2021-07-18
 */
class Solution60 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
