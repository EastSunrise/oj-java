package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/best-line-lcci/">面试题 16.14. Best Line LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Interview14 {

    @Complexity(time = "O(n^3)", space = "O(1)")
    public int[] bestLine(int[][] points) {
        int n = points.length;
        int max = 1;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (max >= n - i || max > n / 2) {
                return ans;
            }
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int x = points[k][0], y = points[k][1];
                    if ((y - y2) * (x - x1) == (x - x2) * (y - y1)) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    ans = new int[]{i, j};
                }
            }
        }
        return ans;
    }
}