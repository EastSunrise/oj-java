package wsg.oj.java.leetcode.problems.p400;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 421. Maximum XOR of Two Numbers in an Array (Medium)
 *
 * @author Kingen
 * @see Solution1707
 * @see <a href="https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/">Maximum
 * XOR of Two Numbers in an Array</a>
 * @since 2021-07-07
 */
class Solution421 implements Solution {

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
