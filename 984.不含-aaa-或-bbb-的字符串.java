/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int a, int b) {
        // 贪心
        // 因为保证会有解，所以每次都优先放多的字母
        // 如果a比b多,就放aab
        // 如果b比a多,就放bba
        // 如果a和b相等,就放ab

        StringBuilder sb = new StringBuilder();
        // 当a比b多时
        while (a > b && b > 0) {
            sb.append("aab");
            a -= 2;
            b -= 1;
        }
        // 当b比a多时
        while (b > a && a > 0) {
            sb.append("bba");
            b -= 2;
            a -= 1;
        }
        // 当a和b相等时
        while (a > 0 && b > 0) {
            sb.append("ab");
            a -= 1;
            b -= 1;
        }
        // 最后把剩下的a或者b放进去
        while (a > 0) {
            sb.append("a");
            a -= 1;
        }
        while (b > 0) {
            sb.append("b");
            b -= 1;
        }
        return sb.toString();
    }
}
// @lc code=end

