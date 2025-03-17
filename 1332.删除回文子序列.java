/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        // 这道题其实有点坑
        // 注意子序列不要求连续,所以对于只包含 a 和 b 的字符串
        // 最多两次就可以删除空, 一次删除所有 a,一次删除所有 b
        // 所有 a 就是原字符串的子序列,因为不要求所有 a 连续
        // 只有当原字符串本身就是个回文串的时候,才可以把次数减为 1

        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
// @lc code=end

