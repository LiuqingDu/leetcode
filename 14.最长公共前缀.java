/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // i 表示第几个字符
        for (int i = 0; i < strs[0].length(); i++) {
            // 从第二个字符串开始比较，如果有不同就直接返回
            for (int j = 1; j < strs.length; j++) {
                // 需要判断 i 是不是超出了字符串的长度
                // 超出长度或者不相等都结束并返回
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
// @lc code=end

