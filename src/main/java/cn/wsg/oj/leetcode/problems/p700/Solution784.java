package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution78;
import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation (MEDIUM)
 *
 * @author Kingen
 * @see Solution78
 * @see Solution1087
 * @see <a href="https://leetcode-cn.com/problems/letter-case-permutation/">Letter Case
 * Permutation</a>
 */
public class Solution784 implements Solution {

    /**
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_N
     */
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        permute(res, s.toCharArray(), 0);
        return res;
    }

    private void permute(List<String> res, char[] tmp, int i) {
        if (i == tmp.length) {
            res.add(new String(tmp));
            return;
        }
        permute(res, tmp, i + 1);
        if ('A' <= tmp[i] && tmp[i] <= 'Z') {
            tmp[i] += 32;
            permute(res, tmp, i + 1);
            tmp[i] -= 32;
        } else if ('a' <= tmp[i] && tmp[i] <= 'z') {
            tmp[i] -= 32;
            permute(res, tmp, i + 1);
            tmp[i] += 32;
        }
    }
}
