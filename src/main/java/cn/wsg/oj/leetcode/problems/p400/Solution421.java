package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array (Medium)
 *
 * @author Kingen
 * @see Solution1707
 * @see <a href="https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/">Maximum
 * XOR of Two Numbers in an Array</a>
 */
public class Solution421 implements Solution {

    /**
     * Predetermines the maximum bit by bit and finds whether there are two prefixes whose XOR is
     * the target.
     *
     * @complexity T=O(32*n)
     * @complexity S=O(n)
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int bit = 30; bit >= 0; bit--) {
            mask += 1 << bit;
            Set<Integer> prefixes = new HashSet<>(nums.length);
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            if (prefixes.size() == 1) {
                continue;
            }
            int target = res + (1 << bit);
            boolean found = false;
            for (int prefix : prefixes) {
                if (prefixes.contains(target ^ prefix)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                res = target;
            }
        }
        return res;
    }
}
