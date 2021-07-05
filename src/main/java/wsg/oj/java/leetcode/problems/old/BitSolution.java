package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class BitSolution {

    // 371. 两整数之和
    public int getSum(int a, int b) {
        int xor = a ^ b;// 原位和
        int carry = (a & b) << 1;// 进位和
        return carry != 0 ? getSum(xor, carry) : xor;
    }
}
