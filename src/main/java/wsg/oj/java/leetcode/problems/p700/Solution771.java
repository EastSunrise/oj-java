package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 771. Jewels and Stones (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/jewels-and-stones/">Jewels and Stones</a>
 * @since 2021-07-26
 */
class Solution771 implements Solution {

    /**
     * @complexity T=O(m+n)
     * @complexity S=O(52)
     */
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean['z' - 'A' + 1];
        for (char ch : jewels.toCharArray()) {
            isJewel[ch - 'A'] = true;
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (isJewel[ch - 'A']) {
                count++;
            }
        }
        return count;
    }
}
