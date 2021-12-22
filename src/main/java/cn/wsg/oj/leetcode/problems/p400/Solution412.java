package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz (Easy)
 *
 * @author Kingen
 * @see Solution1195
 * @see <a href="https://leetcode-cn.com/problems/fizz-buzz/">Fizz Buzz</a>
 */
public class Solution412 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3 && mod5) {
                res.add("FizzBuzz");
            } else if (mod3) {
                res.add("Fizz");
            } else if (mod5) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
