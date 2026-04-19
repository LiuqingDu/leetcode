/*
 * @lc app=leetcode.cn id=1297 lang=java
 *
 * [1297] 子串的最大出现次数
 */

// @lc code=start
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int[] count = new int[26];
        int unique = 0;
        int left = 0, right = 0;
        int res = 0;

        while (right < s.length()) {
            // 加入右边字符
            char c = s.charAt(right);
            if (count[c - 'a'] == 0) unique++;
            count[c - 'a']++;
            right++;

            // 保持窗口大小为 minSize
            if (right - left > minSize) {
                char d = s.charAt(left);
                count[d - 'a']--;
                if (count[d - 'a'] == 0) unique--;
                left++;
            }

            // 满足条件
            if (right - left == minSize && unique <= maxLetters) {
                String sub = s.substring(left, right);
                int freq = map.getOrDefault(sub, 0) + 1;
                map.put(sub, freq);
                res = Math.max(res, freq);
            }
        }

        return res;
    }
}
// @lc code=end

