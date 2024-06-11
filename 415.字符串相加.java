/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        // 从末尾每一位依次相加，索引小于0的直接当0处理
        int x = num1.length() - 1, y = num2.length() - 1;
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (x >= 0 || y >= 0 || add != 0) {
            int a = x >= 0 ? num1.charAt(x) - '0' : 0;
            int b = y >= 0 ? num2.charAt(y) - '0' : 0;
            int sum = a + b + add;
            res.append(sum % 10);
            add = sum / 10;
            x--;
            y--;
        }
        return res.reverse().toString();
    }
}
// @lc code=end

