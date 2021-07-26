package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 412. Fizz Buzz (Easy)
 *
 * @author Kingen
 * @see Solution1195
 * @see <a href="https://leetcode-cn.com/problems/fizz-buzz/">Fizz Buzz</a>
 * @since 2021-07-14
 */
public class Solution412 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3) {
                if (mod5) {
                    res.add("FizzBuzz");
                } else {
                    res.add("Fizz");
                }
            } else {
                if (mod5) {
                    res.add("Buzz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
        }
        return res;
    }
}
