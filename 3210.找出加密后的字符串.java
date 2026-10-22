/*
 * @lc app=leetcode.cn id=3210 lang=java
 *
 * [3210] 找出加密后的字符串
 */

// @lc code=start
class Solution {
    public String getEncryptedString(String s, int k) {
        k %= s.length();
        return s.substring(k) + s.substring(0, k);
    }
}
// @lc code=end

