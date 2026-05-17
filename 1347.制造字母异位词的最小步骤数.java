/*
 * @lc app=leetcode.cn id=1347 lang=java
 *
 * [1347] 制造字母异位词的最小步骤数
 */

// @lc code=start
class Solution {
    public int minSteps(String s, String t) {
        // 统计26个字母出现次数
        int[] count = new int[26];

        // s中的字母 +1
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // t中的字母 -1
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        int ans = 0;

        // 统计差值
        for (int num : count) {
            // 只统计缺少的部分
            if (num > 0) {
                ans += num;
            }
        }

        return ans;
    }
}
// @lc code=end

