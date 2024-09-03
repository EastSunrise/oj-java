package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/similar-string-groups/">839. Similar String Groups</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2157
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution839 {

    @Complexity(time = "O(n^2*m+n*log(n))", space = "O(n)")
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int pi = find(parents, i);
                    int pj = find(parents, j);
                    if (pi != pj) {
                        parents[pj] = pi;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    private int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }

    private boolean isSimilar(String s1, String s2) {
        int diff = 0, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }
}