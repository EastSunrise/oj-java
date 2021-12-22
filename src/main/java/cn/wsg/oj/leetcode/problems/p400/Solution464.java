package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution375;

/**
 * todo 464. Can I Win (Medium)
 *
 * @author Kingen
 * @see Solution294
 * @see Solution375
 * @see Solution486
 * @see <a href="https://leetcode-cn.com/problems/can-i-win/">Can I Win</a>
 */
public class Solution464 implements Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) {
            return false;
        }
        boolean[] chosen = new boolean[maxChoosableInteger + 1];
        return canIWin(maxChoosableInteger, chosen, desiredTotal);
    }

    private boolean canIWin(int max, boolean[] chosen, int target) {
        for (int i = max; i > 0; i--) {
            if (!chosen[i]) {
                if (i >= target) {
                    return true;
                }
                // I choose i
                chosen[i] = true;
                target -= i;
                boolean canWin = true;
                // no matter which number the opponent chooses, I can win
                for (int j = max; j > 0; j--) {
                    if (!chosen[j]) {
                        if (j >= target) {
                            // lose
                            canWin = false;
                            break;
                        }
                        // the opponent chooses j
                        chosen[j] = true;
                        boolean win = canIWin(max, chosen, target - j);
                        chosen[j] = false;
                        if (!win) {
                            // lose
                            canWin = false;
                            break;
                        }
                    }
                }
                chosen[i] = false;
                target += i;
                if (canWin) {
                    return true;
                }
            }
        }
        return false;
    }
}
