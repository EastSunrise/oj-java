package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 66. 构建乘积数组 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/">构建乘积数组 LCOF</a>
 * @since 2021-07-28
 */
public class Offer66 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] products = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            products[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= product;
            product *= a[i];
        }
        return products;
    }
}
