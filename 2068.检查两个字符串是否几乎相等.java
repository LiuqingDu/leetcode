/*
 * @lc app=leetcode.cn id=2068 lang=java
 *
 * [2068] 检查两个字符串是否几乎相等
 */

// @lc code=start
class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        // 两个字符串几乎相等的定义是：它们的字符计数差异不超过 3。
        // 先计算第一个字符串中每个字符的出现次数，然后减去第二个字符串中每个字符的出现次数。
        int[] count = new int[26];
        for (char c : word1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count[c - 'a']--;
        }
        int diffCount = 0;
        for (int c : count) {
            if (c > 3 || c < -3) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

