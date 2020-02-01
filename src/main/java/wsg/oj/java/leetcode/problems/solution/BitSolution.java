package wsg.oj.java.leetcode.problems.solution;

import java.util.*;

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

    // 389. 找不同
    public char findTheDifference(String s, String t) {
        char[] S = s.toCharArray(), T = t.toCharArray();
        int sum = 0;
        for (char c : S)
            sum ^= c;
        for (char c : T)
            sum ^= c;
        return (char) sum;
    }

    // 401. 二进制手表
    public List<String> readBinaryWatch(int num) {
        List<String> list = new LinkedList<>();
        for (int hour = 0; hour < 12; hour++)
            for (int min = 0; min < 60; min++)
                if (getOneCountOfBinary(hour) + getOneCountOfBinary(min) == num)
                    list.add(hour + ":" + ((min < 10) ? "0" : "") + min);
        return list;
    }

    // num >= 0
    private int getOneCountOfBinary(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num >>= 1;
        }
        return count;
    }

    // 405. 数字转换为十六进制数
    public String toHex(int num) {
        return toNRadix(num, 16);
    }

    // N=2,4,8,16  10-15:a-f
    private String toNRadix(int num, int N) {
        if (num == 0)
            return "0";
        else if (num > 0)
            return unsigned2NRadix(num, N);
        num = 0 - num;
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push((num & 1) ^ 1);
            num >>= 1;
        }
        int power = 0;
        while (N > 1) {
            N >>= 1;
            power++;
        }
        while (stack.size() % power != 0)
            stack.push(0);
        StringBuilder stringBuilder = new StringBuilder();
        // wsg 末位加一
        while (!stack.empty()) {
            int value = 0;
            for (int i = 0; i < power; i++)
                value = value * 2 + stack.pop();
            if (value < 10)
                stringBuilder.append(value);
            else
                stringBuilder.append((char) (value + 87));
        }
        return stringBuilder.toString();
    }

    // num>0, 2<=N<=16, 10-15:a-f
    private String unsigned2NRadix(int num, int N) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % N);
            num /= N;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (N > 10)
            while (!stack.empty()) {
                int digit = stack.pop();
                if (digit < 10)
                    stringBuilder.append(digit);
                else
                    stringBuilder.append((char) (digit + 87));
            }
        else
            while (!stack.empty())
                stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }

    // 461. 汉明距离
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return getOneCountOfBinary(xor);
    }

    // 504. 七进制数
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        int value = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % 7);
            value /= 7;
        }
        if (num < 0)
            builder.append("-");
        return builder.reverse().toString();
    }

    // N为正整数, N > 1
    private String convert2baseN(int num, int N) {
        if (num == 0)
            return "0";
        int value = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % N);
            value /= N;
        }
        if (num < 0)
            builder.append("-");
        return builder.reverse().toString();
    }

    // 762. 二进制表示中质数个计算置位
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13));
        int count = 0;
        for (int i = L; i <= R; i++) {
            int count1 = 0, n = i;
            while (n > 0) {
                count1 += n & 1;
                n >>= 1;
            }
            if (set.contains(count1))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

    // 318. 最大单词长度乘积
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                hash[i] |= 1 << (c - 'a');
        for (int i = 0; i < hash.length - 1; i++)
            for (int j = i + 1; j < hash.length; j++)
                if ((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
        return max;
    }
}
