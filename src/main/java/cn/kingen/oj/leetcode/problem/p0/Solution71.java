package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/simplify-path/">71. Simplify Path</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution71 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        int i = 1, j, n = path.length();
        while (i < n) {
            j = path.indexOf('/', i);
            if (j == -1) {
                j = n;
            }
            if (j > i) {
                String name = path.substring(i, j);
                if ("..".equals(name)) {
                    if (!deque.isEmpty()) {
                        deque.pop();
                    }
                } else if (!".".equals(name)) {
                    deque.push(name);
                }
            }
            i = j + 1;
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append("/").append(deque.pollLast());
        }
        return ans.toString();
    }
}