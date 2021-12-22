package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution191;
import java.util.Set;

/**
 * 762. Prime Number of Set Bits in Binary Representation (EASY)
 *
 * @author Kingen
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime
 * Number of Set Bits in Binary Representation</a>
 */
public class Solution762 implements Solution {

    /**
     * @complexity T=O(r-l)
     * @complexity S=O(32)
     */
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }
}
