/*
 * @lc app=leetcode.cn id=1796 lang=java
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }
}
// @lc code=end

