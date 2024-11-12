package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/">3211. Generate Binary Strings Without Adjacent Zeros</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution600
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.RECURSION, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3211 {

    @Complexity(time = "O(2^n)", space = "O(n)")
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, n, new char[n], 0);
        return ans;
    }

    private void dfs(List<String> ans, int n, char[] tmp, int i) {
        if (i == n) {
            ans.add(new String(tmp));
            return;
        }
        tmp[i] = '1';
        dfs(ans, n, tmp, i + 1);
        if (i == 0 || tmp[i - 1] == '1') {
            tmp[i] = '0';
            dfs(ans, n, tmp, i + 1);
        }
    }
}