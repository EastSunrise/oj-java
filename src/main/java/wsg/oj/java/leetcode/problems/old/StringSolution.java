package wsg.oj.java.leetcode.problems.old;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kingen
 */
public class StringSolution {

    // 537. 复数乘法
    public String complexNumberMultiply(String a, String b) {
        int[] aInts = getInts(a), bInts = getInts(b);
        return "" + (aInts[0] * bInts[0] - aInts[1] * bInts[1])
            + "+" + (aInts[0] * bInts[1] + aInts[1] * bInts[0]) + "i";
    }

    private int[] getInts(String s) {
        String[] ss = s.substring(0, s.length() - 1).split("\\+");
        return new int[]{
            Integer.parseInt(ss[0]), Integer.parseInt(ss[1])
        };
    }

    // 816. 模糊坐标
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> list = new LinkedList<>();
        for (int comma = 1; comma < S.length(); comma++) {
            for (String s1 : getValidString(S.substring(0, comma))) {
                for (String s2 : getValidString(S.substring(comma))) {
                    list.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return list;
    }

    private List<String> getValidString(String s) {
        List<String> list = new LinkedList<>();
        if (s.endsWith("0")) {
            if ("0".equals(s) || !s.startsWith("0")) {
                list.add(s);
            }
        } else if (s.startsWith("0")) {
            list.add("0." + s.substring(1));
        } else {
            list.add(s);
            for (int i = 1; i < s.length(); i++) {
                list.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return list;
    }

    static class GroupValue {

        int groupId;
        double value;

        GroupValue(int groupId, double value) {
            this.groupId = groupId;
            this.value = value;
        }
    }
}