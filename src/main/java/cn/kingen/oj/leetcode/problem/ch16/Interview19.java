package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.ArrayUtils.EIGHT_DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/pond-sizes-lcci/">面试题 16.19. Pond Sizes LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Interview19 {

    @Complexity(time = "O(mn*log{mn})", space = "O(m+n)")
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    ans.add(dfs(land, i, j));
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int count = 1;
        for (int[] d : EIGHT_DIRECTIONS) {
            count += dfs(land, i + d[0], j + d[1]);
        }
        return count;
    }
}