package wsg.oj.java.leetcode.problems.p400;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 475. Heaters (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/heaters/">Heaters</a>
 * @since 2021-07-09
 */
class Solution475 implements Solution {

    /**
     * @complexity T=O(m*log{m}+n*log{n})
     * @complexity S=O(1)
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, radius = 0;
        while (left < houses.length && houses[left] <= heaters[0]) {
            radius = Math.max(radius, heaters[0] - houses[left]);
            left++;
        }
        int right = houses.length - 1, last = heaters[heaters.length - 1];
        while (right >= 0 && houses[right] >= last) {
            radius = Math.max(radius, houses[right] - last);
            right--;
        }
        if (heaters.length == 1) {
            return radius;
        }
        int h = 1;
        for (int i = left; i <= right; i++) {
            while (houses[i] >= heaters[h]) {
                h++;
            }
            radius = Math.max(radius, Math.min(houses[i] - heaters[h - 1], heaters[h] - houses[i]));
        }
        return radius;
    }
}
