package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/living-people-lcci/">面试题 16.10. Living People LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview10 {

    @Complexity(time = "O(m+n)", space = "O(m)")
    public int maxAliveYear(int[] birth, int[] death) {
        int n = birth.length;
        int min = 2000, max = 1900;
        for (int b : birth) {
            min = Math.min(min, b);
            max = Math.max(max, b);
        }
        int m = max - min + 1;
        int[] changes = new int[m];
        for (int i = 0; i < n; i++) {
            int b = birth[i], d = death[i];
            changes[b - min]++;
            if (d - min + 1 < m) {
                changes[d - min + 1]--;
            }
        }
        int maxAlive = changes[0], maxAliveYear = min;
        for (int i = 1; i < m; i++) {
            changes[i] += changes[i - 1];
            if (changes[i] > maxAlive) {
                maxAlive = changes[i];
                maxAliveYear = i + min;
            }
        }
        return maxAliveYear;
    }
}