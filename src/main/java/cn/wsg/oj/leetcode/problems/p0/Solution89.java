package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution717;
import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code (Medium)
 *
 * @author Kingen
 * @see Solution717
 * @see <a href="https://leetcode-cn.com/problems/gray-code/">Gray Code</a>
 */
public class Solution89 implements Solution {

    /**
     * G(n+1) = G(n) + (Reverse(G(n)) + 2^n)
     *
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_2_N
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);
        res.add(1);
        int power = 2;
        while (n-- > 1) {
            for (int i = res.size() - 1; i >= 0; i--) {
                res.add(res.get(i) + power);
            }
            power *= 2;
        }
        return res;
    }

    /**
     * G(i) = G(i ^ (i>>1))
     *
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_2_N
     */
    public List<Integer> grayCode2(int n) {
        int count = 1 << n;
        List<Integer> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
