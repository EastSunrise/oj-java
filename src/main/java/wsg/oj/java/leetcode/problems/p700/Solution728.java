package wsg.oj.java.leetcode.problems.p700;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution507;

/**
 * 728. Self Dividing Numbers (EASY)
 *
 * @author Kingen
 * @see Solution507
 * @see <a href="https://leetcode-cn.com/problems/self-dividing-numbers/">Self Dividing Numbers</a>
 * @since 2021-07-26
 */
public class Solution728 implements Solution {

    /**
     * @complexity T=(32*(r-l))
     * @complexity S=O(1)
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean flag = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0 || i % digit != 0) {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }
}
