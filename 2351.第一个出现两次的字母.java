/*
 * @lc app=leetcode.cn id=2351 lang=java
 *
 * [2351] 第一个出现两次的字母
 */

// @lc code=start
class Solution {
    public char repeatedCharacter(String s) {
        int seen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int x = ch - 'a';
            if ((seen & (1 << x)) != 0) {
                return ch;
            }
            seen |= (1 << x);
        }
        // impossible
        return ' ';
    }
}
// @lc code=end

