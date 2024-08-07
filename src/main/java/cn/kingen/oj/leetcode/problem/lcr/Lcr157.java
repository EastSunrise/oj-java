package cn.kingen.oj.leetcode.problem.lcr;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/">LCR 157. 套餐内商品的排列顺序</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Lcr157 {

    @Complexity(time = "O(n*n!)", space = "O(n)")
    public String[] goodsOrder(String goods) {
        int n = goods.length();
        char[] chars = goods.toCharArray();
        Arrays.sort(chars);

        List<String> ans = new ArrayList<>();
        dfs(ans, chars, new boolean[n], n, 0, new char[n]);
        return ans.toArray(new String[0]);
    }

    private void dfs(List<String> ans, char[] chars, boolean[] visited, int n, int i, char[] tmp) {
        if (i == n) {
            ans.add(new String(tmp));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[j] || (j > 0 && chars[j] == chars[j - 1] && !visited[j - 1])) { // not skip the same char
                continue;
            }

            visited[j] = true;
            tmp[i] = chars[j];
            dfs(ans, chars, visited, n, i + 1, tmp);
            visited[j] = false;
        }
    }
}