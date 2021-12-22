package cn.wsg.oj.algorithm.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Regular expression.
 *
 * @author Kingen
 */
public class RegularExp {

    private static final char END = '$';
    private static final char DOT = '.';
    private static final char NONE = 'ε';
    private static final char ANY = '*';

    private final List<Map<Character, Integer>> states;

    RegularExp(List<Map<Character, Integer>> states) {
        this.states = states;
    }

    /**
     * Construct DFA.
     */
    public static RegularExp compile(String regex) {
        regex += END;
        List<Map<Character, Integer>> states = new ArrayList<>(regex.length());
        Map<Character, Integer> current = new HashMap<>(2);
        states.add(current);
        for (int i = 1; i < regex.length(); i++) {
            char prev = regex.charAt(i - 1);
            char cur = regex.charAt(i);
            if (cur == ANY) {
                // point to current state
                current.put(prev, states.size() - 1);
                // point to next state
                current.put(NONE, states.size());
                i++;
            } else {
                // point to next state
                current.put(prev, states.size());
            }
            // add next state
            current = new HashMap<>(2);
            states.add(current);
        }
        current.put(END, -1);
        return new RegularExp(states);
    }

    public boolean matches(String s) {
        return matches(s + END, 0, 0);
    }

    private boolean matches(String s, int idx, int state) {
        if (idx == s.length()) {
            return state == -1;
        }
        Map<Character, Integer> transition = states.get(state);
        char ch = s.charAt(idx);
        // check current char: the same character, 'ε' or the wildcard '.'
        // go to next state if matched
        if (transition.containsKey(ch) && matches(s, idx + 1, transition.get(ch))) {
            return true;
        }
        if (transition.containsKey(DOT) && matches(s, idx + 1, transition.get(DOT))) {
            return true;
        }
        return transition.containsKey(NONE) && matches(s, idx, transition.get(NONE));
    }

}
