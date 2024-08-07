package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-string-after-change/">1702. Maximum Binary String After Change</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2311
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1702 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int i = 0;
        while (i < n && binary.charAt(i) == '1') {
            i++;
        }
        if (i == n) {
            return binary;
        }
        // [i,...,j]=011...110 converted to 101...111
        // so zero at i shift to right by 1 once there is another zero
        for (int j = i + 1; j < n; j++) {
            if (binary.charAt(j) == '0') {
                i++;
            }
        }
        return "1".repeat(i) + "0" + "1".repeat(n - i - 1);
    }
}