/*
 * @lc app=leetcode.cn id=1309 lang=java
 *
 * [1309] 解码字母到整数映射
 */

// @lc code=start
class Solution {
    public String freqAlphabets(String s) {
        // 从左往右比较复杂,对于遇到 1 和 2 需要看下一位是什么
        // 从右往左就简单了,如果是 # 则它左边两位也是一起的
        // 如果不是 # 则当前一位对应一个字母
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (i >= 2 && s.charAt(i) == '#') {
                // 如果当前字符是 '#', 说明前两个字符是数字，转换成字母
                int num = Integer.parseInt(s.substring(i - 2, i));
                result.append((char) ('a' + num - 1));
                i -= 3; // 跳过这个3个字符
            } else {
                // 否则当前字符是数字，直接转换
                int num = s.charAt(i) - '0';
                result.append((char) ('a' + num - 1));
                i--;
            }
        }
        return result.reverse().toString();
    }
}
// @lc code=end

