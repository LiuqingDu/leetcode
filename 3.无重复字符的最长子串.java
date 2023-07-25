/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int res = 0;

        // 滑动窗口
        // 窗口记录每个字符出现的次数，本题要求不重复，
        // 则要么不出现，要么出现次数必须为 1
        // 每次把右指针往右移动一位，把该字符次数更新到窗口里
        // 当次数大于 1 的时候，开始缩小窗口，把左指针往右移动，
        // 直到次数等于 1
        // 此时两个指针之间就是不重复字符串的长度
        // 比较最大值即可
        // 注意右指针起始是 0，右边是开区间，
        // 右指针指向的字符不包含在窗口内，因此可以直接
        // 用right - left 得出长度

        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.get(c) == null ? 1 : window.get(c) + 1);
            
            while(window.get(c) > 1) {
                char d = s.charAt(left);
                left ++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end

