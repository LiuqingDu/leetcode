/*
 * @lc app=leetcode.cn id=2287 lang=java
 *
 * [2287] 重排字符形成目标字符串
 */

// @lc code=start
class Solution {
    public int rearrangeCharacters(String s, String target) {
        // 统计 s 的字符频率
        int[] freqS = new int[26];
        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        // 统计 target 的字符频率
        int[] freqT = new int[26];
        for (char c : target.toCharArray()) {
            freqT[c - 'a']++;
        }

        // 计算最多能形成多少份 target
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freqT[i] > 0) {
                ans = Math.min(ans, freqS[i] / freqT[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end

