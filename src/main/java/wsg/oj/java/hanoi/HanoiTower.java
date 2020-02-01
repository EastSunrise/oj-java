package wsg.oj.java.hanoi;

/**
 * 汉诺塔
 *
 * @author Kingen
 */
public class HanoiTower {

    private ASCStack<Integer> a;
    private ASCStack<Integer> b;
    private ASCStack<Integer> c;

    public HanoiTower(int number) {
        a = new ASCStack<>();
        b = new ASCStack<>();
        c = new ASCStack<>();
        for (int i = 0; i < number; i++) {
            try {
                a.push(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public long hanoi() throws Exception {
        return hanoi(a, b, c, a.size());
    }

    private long hanoi(ASCStack<Integer> a, ASCStack<Integer> b, ASCStack<Integer> c, int size) throws Exception {
        if (size == 1) {
            c.push(a.pop());
            return 1;
        } else if (size > 1) {
            long step = 0;
            step += hanoi(a, c, b, size - 1);
            c.push(a.pop());
            step += 1;
            step += hanoi(b, a, c, size - 1);
            return step;
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 64; i++) {
            HanoiTower hanoiTower = new HanoiTower(i);
            try {
                long start = System.currentTimeMillis();
                long step = hanoiTower.hanoi();
                System.out.println(i + ": " + step + ", " + (System.currentTimeMillis() - start));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
