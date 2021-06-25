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

    // N为正整数, N > 1
    private String convert2baseN(int num, int N) {
        if (num == 0) {
            return "0";
        }
        int value = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % N);
            value /= N;
        }
        if (num < 0) {
            builder.append("-");
        }
        return builder.reverse().toString();
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
