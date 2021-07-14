package wsg.oj.java.leetcode.problems.p400;

import java.util.Random;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 470. Implement Rand10() Using Rand7() (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/">Implement Rand10()
 * Using Rand7()</a>
 * @since 2021-07-09
 */
public class Solution470 implements Solution {

    /**
     * Assume that a is the number of calls to rand7() every time and p is the probability that the
     * value is invalid, then the expected value E = a*(1+p+p^2+...) = a/(1-p). And
     * p=(7^a-[(7^a)/10]*10)/7^a.
     * <p>
     * If a=2, p=9/49 and E=49/20.
     */
    public int rand10() {
        int val = (rand7() * 7 + rand7() - 4) / 4;
        return val <= 10 ? val : rand10();
    }

    /**
     * @return a random integer in the range 1 to 7
     */
    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
