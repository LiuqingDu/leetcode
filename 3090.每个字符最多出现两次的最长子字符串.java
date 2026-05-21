/*
 * @lc app=leetcode.cn id=3090 lang=java
 *
 * [3090] 每个字符最多出现两次的最长子字符串
 */

// @lc code=start
class Solution {
    public int maximumLengthSubstring(String s) {

        int[] count = new int[26];

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            count[c - 'a']++;

            // 如果当前字符超过2次，缩小窗口
            while (count[c - 'a'] > 2) {

                char leftChar = s.charAt(left);

                count[leftChar - 'a']--;

                left++;
            }

            // 更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
// @lc code=end

