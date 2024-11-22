package cn.kingen.oj.leetcode.problem.p3200;

import static cn.kingen.oj.leetcode.util.MathUtils.getPrimes;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-the-count-of-numbers-which-are-not-special/">3233. Find the Count of Numbers Which Are Not Special</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution204

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATH, Tag.NUMBER_THEORY},
    difficulty = Difficulty.MEDIUM
)
public class Solution3233 {

    @Complexity(time = "O(sqrt(r))", space = "O(sqrt(r))")
    public int nonSpecialCount(int l, int r) {
        int a = (int) Math.sqrt(l), b = (int) Math.sqrt(r);
        if (a * a < l) {
            a++;
        }
        List<Integer> primes = getPrimes(b);
        int i = Collections.binarySearch(primes, a);
        if (i < 0) {
            i = -i - 1;
        }
        int spec = primes.size() - i;
        return r - l + 1 - spec;
    }
}