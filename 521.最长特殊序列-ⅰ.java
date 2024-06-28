/*
 * @lc app=leetcode.cn id=521 lang=java
 *
 * [521] 最长特殊序列 Ⅰ
 */

// @lc code=start
class Solution {
    public int findLUSlength(String a, String b) {
        // 如果两个字符串相同，那么不存在最长特殊序列
        // 如果两个字符串不同，那么长的那个就是其中一个最长特殊序列
        // 因为短的必然不包含长的
        // 如果字符串不同，且长度相同，那么也可以得出其中一个字符串就是最长特殊序列
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
// @lc code=end

