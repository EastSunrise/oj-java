package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/">打印从1到最大的n位数
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer17 implements Solution {

    /**
     * @complexity T=O(10^n)
     * @complexity S=O(10^n)
     */
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
