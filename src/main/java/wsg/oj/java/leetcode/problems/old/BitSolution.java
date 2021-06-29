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

    // 318. 最大单词长度乘积
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < hash.length - 1; i++) {
            for (int j = i + 1; j < hash.length; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}
