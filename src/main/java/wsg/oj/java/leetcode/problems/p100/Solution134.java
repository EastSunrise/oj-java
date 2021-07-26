package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 134. Gas Station (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/gas-station/">Gas Station</a>
 * @since 2021-07-12
 */
public class Solution134 implements Solution {

    /**
     * Assume that the left gas is G(s,t) when traveling from station s to station t:
     * <p>
     * Try traveling from station s to t and the station t is reachable and the gas is not enough
     * from t to t+1, for s&le;i&le;t:
     * <p>d[i] = gas[i]-cost[i]</p>
     * <p>G(s,t) = G(s,i)+G(i,t)</p>
     * <p>G(s,i) >= 0</p>
     * <p>G(s,t+1) = G(s,t)+d[t] < 0</p>
     * Therefore,
     * <p>G(i,t+1) = G(i,t)+d[t] = G(s,t)+d[t]-G(s,i) < 0</p>
     * which means that it's unreachable from station i to t+1 when s&le;i&le;t. Then start from
     * t+1.
     * <p>
     * When reaching the end, the total left is R:
     * <p>s0=0</p>
     * <p>G(s0,t0)+d[t0]<0, s1=t0+1</p>
     * <p>G(s1,t1)+d[t1]<0, s2=t1+1</p>
     * <p>...</p>
     * <p>G(sj,tj)+d[tj]<0, s{j+1}=tj+1</p>
     * <p>R = sum(G(si,ti)+d[ti]) + G(s{j+1},n) > 0, 0<=i<=j</p>
     * Therefore,
     * <p>G(s{j+1},n)+G(s0,t0)+d[t0] = R - sum(G(si,ti)+d[ti]) > 0, 1<=i<=j</p>
     * which means that it's reachable from s{j+1} to s1. In the same way, it's reachable from
     * s{j+1} to sj.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, start = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            rest += (gas[i] - cost[i]);
            sum += (gas[i] - cost[i]);
            if (rest < 0) {
                rest = 0;
                start = i + 1;
            }
        }
        return sum >= 0 ? start : -1;
    }
}
