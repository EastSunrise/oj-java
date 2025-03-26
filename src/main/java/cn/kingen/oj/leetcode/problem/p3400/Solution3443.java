package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-manhattan-distance-after-k-changes/">3443. Maximum Manhattan Distance After K Changes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1162

 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM,
        contest = 435
)
public class Solution3443 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxDistance(String s, int k) {
        int n = s.length(), ans = 0;
        int nc = 0, sc = 0, ec = 0, wc = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'N':
                    nc++;
                    break;
                case 'S':
                    sc++;
                    break;
                case 'E':
                    ec++;
                    break;
                case 'W':
                    wc++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid character: " + s.charAt(i));
            }
            int xmn = Math.min(ec, wc), ymn = Math.min(sc, nc);
            ans = Math.max(ans, Math.abs(ec - wc) + Math.abs(sc - nc) + Math.min(k, xmn + ymn) * 2);
        }
        return ans;
    }
}