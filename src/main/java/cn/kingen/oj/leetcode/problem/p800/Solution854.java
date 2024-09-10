package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/k-similar-strings/">854. K-Similar Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution765
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution854 {

    @Complexity(time = "#", space = "#")
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        long start = 0, end = 0, bits = 0;
        for (int i = 0; i < n; i++) {
            int ch1 = s1.charAt(i) - 'a', ch2 = s2.charAt(i) - 'a';
            if (ch1 != ch2) {
                start = (start << 3) + ch1;
                end = (end << 3) + ch2;
                bits += 3;
            }
        }
        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{start, end, bits});
        for (int k = 0; !queue.isEmpty(); k++) { // start->{k operations}->end
            for (int size = queue.size(); size > 0; size--) {
                long[] arr = queue.remove();
                long x = arr[0], y = arr[1], z = arr[2];
                if (x == y) {
                    return k;
                }
                long x0 = x & 0b111, y0 = y & 0b111;
                for (long p = 3; p < z; p += 3) { // find y0 in x and switch x0 and y0 in x
                    if ((x >> p & 0b111) == y0) {
                        if ((y >> p & 0b111) == x0) { // remove the same 6 bits if x=...y0...x0 and y=...x0...y0
                            long mask = (1L << p) - 1;
                            long xx = x >> (p + 3) << (p - 3) | ((x & mask) >> 3);
                            long yy = y >> (p + 3) << (p - 3) | ((y & mask) >> 3);
                            queue.offer(new long[]{xx, yy, z - 6});
                        } else { // or only remove the last same 3 bits
                            queue.offer(new long[]{(x ^ (y0 << p) | (x0 << p)) >> 3, y >> 3, z - 3});
                        }
                    }
                }
            }
        }
        return -1;
    }
}