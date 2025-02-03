/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 如果 str1 和 str2 拼接后等于 str2和 str1 拼接起来的字符串
        // （注意拼接顺序不同），那么一定存在符合条件的字符串 X
        // 如果存在, 那么它的长度一定是 str1 和 str2 的长度的最大公约数
        
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
// @lc code=end

