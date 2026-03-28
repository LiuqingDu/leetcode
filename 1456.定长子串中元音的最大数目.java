/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        
        int max = 0;     // 记录最大元音数
        int count = 0;   // 当前窗口中的元音数

        // 初始化第一个长度为 k 的窗口
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        max = count;

        // 滑动窗口：每次右移一位
        for (int i = k; i < s.length(); i++) {
            // 新进入窗口的字符
            if (isVowel(s.charAt(i))) {
                count++;
            }
            // 移出窗口的字符
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            // 更新最大值
            max = Math.max(max, count);
        }

        return max;
    }

    // 判断是否为元音字符
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end

