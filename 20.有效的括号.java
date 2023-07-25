/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (Character c: s.toCharArray()) {
            if (c=='{'|| c=='['||c=='(') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                if (c != getPair(st.pop())) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    private Character getPair(Character c) {
        if (c == '{') {
            return '}';
        }
        else if (c =='[') {
            return ']';
        }
        else {
            return ')';
        }
    }
}
// @lc code=end

