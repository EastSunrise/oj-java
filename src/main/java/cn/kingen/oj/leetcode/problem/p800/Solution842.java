package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-array-into-fibonacci-sequence/">842. Split Array into Fibonacci Sequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution306
 * @see cn.kingen.oj.leetcode.problem.p500.Solution509
 */
@Question(
        tags = {Tag.STRING, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution842 {

    @Complexity(time = "O(n*(log(C))^2)", space = "O(n)", note = "C is the maximum integer")
    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length(), half = n >> 1;
        if (n <= 2) {
            return List.of();
        }

        int[] f = new int[n];
        long a = 0;
        for (int i = 0; i < half; i++) {
            a = a * 10 + num.charAt(i) - '0'; // a = num[0, i]
            if (a > Integer.MAX_VALUE || (i == 1 && num.charAt(0) == '0')) { // overflow or leading zero
                break;
            }
            f[0] = (int) a;
            long b = 0;
            for (int j = i + 1; j < n; j++) {
                b = b * 10 + num.charAt(j) - '0'; // b = num[i+1, j]
                if (b > Integer.MAX_VALUE || (j == i + 2 && num.charAt(i + 1) == '0')) { // overflow or leading zero
                    break;
                }
                f[1] = (int) b;
                int size = isFibonacci(a, b, num, j + 1, f, 2);
                if (size >= 3) {
                    List<Integer> ans = new ArrayList<>(size);
                    for (int k = 0; k < size; k++) {
                        ans.add(f[k]);
                    }
                    return ans;
                }
            }
        }
        return List.of();
    }

    private int isFibonacci(long a, long b, String num, int i, int[] f, int size) {
        if (i >= num.length()) {
            return size;
        }
        long c = a + b;
        if (c > Integer.MAX_VALUE) {
            return -1;
        }
        String cstr = String.valueOf(c);
        if (!num.startsWith(cstr, i)) {
            return -1;
        }
        f[size++] = (int) c;
        return isFibonacci(b, c, num, i + cstr.length(), f, size);
    }
}