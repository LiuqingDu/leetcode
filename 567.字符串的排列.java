/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {

    // 是一个长度固定的滑动窗口题目
    // 类似题目438.
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] need = new int[26];
        int[] window = new int[26];

        // 初始化目标值和窗口值
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        // left标记窗口左边，因为窗口长度固定，所以不需要记录窗口右边
        // 实际上left可以等于 s2.len-s1.len，但此时循环体内的窗口右边框：left+s1.len会超出索引范围，
        // 因此这里不处理相等的情况，循环体之后再判断一次，这次就是处理相等的情况了
        // 这道题额外判断的语句跟return合在一起了，因为本来也就是需要返回boolean
        while(left < s2.length() - s1.length()) {
            if (Arrays.equals(need, window)) {
                return true;
            }
            window[s2.charAt(left) - 'a']--;
            window[s2.charAt(left + s1.length()) - 'a']++;
            left++;
        }

        return Arrays.equals(need, window);
    }
}
// @lc code=end

