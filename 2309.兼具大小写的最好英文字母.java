/*
 * @lc app=leetcode.cn id=2309 lang=java
 *
 * [2309] 兼具大小写的最好英文字母
 */

// @lc code=start
class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 25; i >= 0; i--) {
            char upper = (char) ('A' + i);
            char lower = (char) ('a' + i);
            if (set.contains(upper) && set.contains(lower)) {
                return String.valueOf(upper);
            }
        }

        return "";
    }
}
// @lc code=end

