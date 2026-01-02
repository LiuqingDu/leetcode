/*
 * @lc app=leetcode.cn id=2716 lang=java
 *
 * [2716] 最小化字符串长度
 */

// @lc code=start
class Solution {
    public int minimizedStringLength(String s) {
        int mask = 0;
        for (var c : s.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return Integer.bitCount(mask);
    }
}
// @lc code=end

