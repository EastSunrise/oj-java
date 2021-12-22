package cn.wsg.oj.hanoi;

/**
 * Hanoi Tower.
 *
 * @author Kingen
 */
public class HanoiTower {

    public long hanoi(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("At least one plate");
        }
        AscendingStack a = new AscendingStack();
        AscendingStack b = new AscendingStack();
        AscendingStack c = new AscendingStack();
        for (int i = 1; i < n; i++) {
            a.push(i);
        }
        return move(a, b, c, a.size());
    }

    private long move(AscendingStack src, AscendingStack tmp, AscendingStack dest, int size) {
        if (size == 1) {
            dest.push(src.pop());
            return 1;
        }
        long step = 0;
        step += move(src, dest, tmp, size - 1);
        dest.push(src.pop());
        step += 1;
        step += move(tmp, src, dest, size - 1);
        return step;
    }
}
