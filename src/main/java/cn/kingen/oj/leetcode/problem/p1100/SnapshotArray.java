package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/snapshot-array/">1146. Snapshot Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class SnapshotArray {

    // snapshots[i][j] = [snap_id, val]
    private final List<List<int[]>> snapshots;
    private int snapId;

    @Complexity(time = "O(n)", space = "O(n)", note = "n is the length of the array")
    SnapshotArray(int length) {
        this.snapshots = new ArrayList<>(length);
        this.snapId = 0;
        for (int i = 0; i < length; i++) {
            this.snapshots.add(new ArrayList<>(1));
            this.snapshots.get(i).add(new int[]{snapId, 0});
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void set(int index, int val) {
        List<int[]> list = this.snapshots.get(index);
        int[] last = list.getLast();
        if (last[0] == this.snapId) { // update value at the same snapshot
            last[1] = val;
        } else { // add new snapshot
            list.add(new int[]{this.snapId, val});
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int snap() {
        this.snapId++;
        return this.snapId - 1;
    }

    @Complexity(time = "O(log{S})", space = "O(1)", note = "S is the count of snaps")
    int get(int index, int snapId) {
        List<int[]> list = this.snapshots.get(index);

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int[] t = list.get(mid);
            int cmp = t[0] - snapId;

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return t[1]; // key found
        }
        return list.get(high)[1];
    }
}