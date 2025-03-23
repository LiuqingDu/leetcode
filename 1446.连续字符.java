/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        // 双指针,指针中间是同一个字符

        int n = s.length();
        int res = 0;
        int left = 0;
        int right = 0;
        while (left < n) {
            right = left;
            while (right < n && s.charAt(right) == s.charAt(left)) {
                right++;
            }
            res = Math.max(res, right - left);
            left = right;
        }
        return res;
    }
}
// @lc code=end

