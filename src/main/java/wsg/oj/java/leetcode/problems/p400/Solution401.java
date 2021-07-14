package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution17;
import wsg.oj.java.leetcode.problems.p100.Solution191;

/**
 * 401. Binary Watch (Easy)
 *
 * @author Kingen
 * @see Solution17
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/binary-watch/">Binary Watch</a>
 * @since 2021-07-14
 */
public class Solution401 implements Solution {

    /**
     * @see #BACKTRACKING
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int hCount = 0; hCount < 4; hCount++) {
            int minCount = turnedOn - hCount;
            if (minCount >= 0 && minCount < 6) {
                List<Integer> hours = new ArrayList<>();
                possibles(hours, 0, 4, hCount);
                List<Integer> minutes = new ArrayList<>();
                possibles(minutes, 0, 6, minCount);
                for (int h : hours) {
                    if (h < 12) {
                        for (int min : minutes) {
                            if (min < 60) {
                                res.add(String.format("%d:%02d", h, min));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private void possibles(List<Integer> res, int tmp, int digits, int bitCount) {
        if (bitCount == 0) {
            res.add(tmp << digits);
            return;
        }
        possibles(res, (tmp << 1) + 1, digits - 1, bitCount - 1);
        if (digits > bitCount) {
            possibles(res, tmp << 1, digits - 1, bitCount);
        }
    }
}
