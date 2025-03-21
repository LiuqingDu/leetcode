/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        // n 是奇数就返回一种字符
        // n 是偶数就返回 n-1 个 a 和一个 b
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 1) {
            return sb.append("a".repeat(n)).toString();
        }
        return sb.append("a".repeat(n - 1)).append("b").toString();
    }
}
// @lc code=end

