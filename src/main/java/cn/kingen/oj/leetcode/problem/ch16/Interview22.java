package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cn.kingen.oj.leetcode.util.ArrayUtils.DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/langtons-ant-lcci/">面试题 16.22. Langtons Ant LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.MATRIX, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Interview22 {

    @Complexity(time = "O(k)", space = "O(k)")
    public List<String> printKMoves(int k) {
        Set<Integer> blacks = new HashSet<>();
        int d = 0; // 0-right, 1-down, 2-left, 3-up
        int r = 0x3fff, c = 0x3fff; // row from up to down and column from left to right
        while (k > 0) {
            int key = (r << 16) + c;
            if (blacks.add(key)) { // white to black
                d = (d + 1) % 4;
            } else { // black to white
                blacks.remove(key);
                d = (d + 3) % 4;
            }
            r += DIRECTIONS[d][0];
            c += DIRECTIONS[d][1];
            k--;
        }
        int minr = r, maxr = r, minc = c, maxc = c, mask = 0xffff;
        for (int key : blacks) {
            int i = key >> 16, j = key & mask;
            minr = Math.min(minr, i);
            maxr = Math.max(maxr, i);
            minc = Math.min(minc, j);
            maxc = Math.max(maxc, j);
        }
        int m = maxr - minr + 1, n = maxc - minc + 1;
        List<String> ans = new ArrayList<>(m);
        for (int i = minr; i <= maxr; i++) {
            StringBuilder sb = new StringBuilder(n);
            for (int j = minc; j <= maxc; j++) {
                if (i == r && j == c) {
                    sb.append(new char[]{'R', 'D', 'L', 'U'}[d]);
                    continue;
                }
                int key = (i << 16) + j;
                if (blacks.contains(key)) {
                    sb.append('X');
                } else {
                    sb.append('_');
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}