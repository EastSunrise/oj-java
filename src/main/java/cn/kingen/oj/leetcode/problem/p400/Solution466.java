package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-the-repetitions/">466. Count The Repetitions</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution466 {

    @Complexity(time = "O(|s1|*|s2|)", space = "O(|s2|)")
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int cnt1 = 0, index = 0, cnt2 = 0;
        Map<Integer, Integer> recall1 = new HashMap<>(), recall2 = new HashMap<>();
        while (true) {
            cnt1++;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index += 1;
                    if (index == s2.length()) {
                        cnt2++;
                        index = 0;
                    }
                }
            }
            if (cnt1 == n1) {
                return cnt2 / n2;
            }
            if (recall1.containsKey(index)) {
                break;
            }
            recall1.put(index, cnt1);
            recall2.put(index, cnt2);
        }
        int preCnt1 = recall1.get(index), preCnt2 = recall2.get(index);
        int loopCnt1 = cnt1 - preCnt1, loopCnt2 = cnt2 - preCnt2;
        int ans = preCnt2 + (n1 - preCnt1) / loopCnt1 * loopCnt2;

        int rest = (n1 - preCnt1) % loopCnt1;
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }
}