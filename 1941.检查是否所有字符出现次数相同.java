/*
 * @lc app=leetcode.cn id=1941 lang=java
 *
 * [1941] 检查是否所有字符出现次数相同
 */

// @lc code=start
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26]; // 因为都是小写字母

        // 统计每个字符的出现次数
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // 找第一个非 0 的次数作为比较标准
        int freq = 0;
        for (int c : count) {
            if (c != 0) {
                if (freq == 0) {
                    freq = c; // 第一个非0的数，设为标准
                } else if (c != freq) {
                    return false; // 有不同的次数，返回 false
                }
            }
        }

        return true; // 所有字符出现次数都一样
    }
}
// @lc code=end

