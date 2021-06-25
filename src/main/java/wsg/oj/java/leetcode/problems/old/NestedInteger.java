package wsg.oj.java.leetcode.problems.old;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kingen
 */
class NestedInteger {

    private final boolean isInteger;
    List<NestedInteger> list;
    Integer value;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        list = new LinkedList<>();
        isInteger = false;
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
        isInteger = true;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return isInteger ? value : null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        if (isInteger) {
            this.value = value;
        }
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (!isInteger) {
            list.add(ni);
        }
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return isInteger ? null : list;
    }
}
