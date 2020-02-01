package wsg.oj.java.solution;

/**
 * @author Kingen
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 1, min = 1;
        for (int pile : piles) {
            if (pile > max)
                max = pile;
        }
        while (min <= max) {
            int mid = (max + min) >> 1;
            int total = 0;
            for (int pile : piles) {
                total += (pile - 1) / mid + 1;
            }
            if (total > H)
                min = mid + 1;
            else if (total < H)
                max = mid - 1;
            else
                return mid;
        }
        return min;
    }

    public static void main(String[] args) {
        new Solution().minEatingSpeed(new int[]{
                3, 6, 7, 11
        }, 8);
    }
}

