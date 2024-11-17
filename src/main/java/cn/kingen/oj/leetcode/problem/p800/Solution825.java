package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/friends-of-appropriate-ages/">825. Friends Of Appropriate Ages</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution825 {

    @Complexity(time = "O(m^2+n)", space = "O(m)")
    public int numFriendRequests(int[] ages) {
        int m = 121;
        int[] cnt = new int[m];
        for (int age : ages) {
            cnt[age]++;
        }
        int sum = 0;
        for (int x = 1; x < m; x++) {
            if (cnt[x] == 0) {
                continue;
            }
            for (int y = 1; y < m; y++) {
                if (cnt[y] == 0) {
                    continue;
                }
                if (2 * y <= x + 14 || y > x) {
                    continue;
                }
                if (x == y) { // exclude self
                    sum += (cnt[x] - 1) * cnt[y];
                } else {
                    sum += cnt[x] * cnt[y];
                }
            }
        }
        return sum;
    }
}