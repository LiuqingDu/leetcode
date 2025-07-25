/*
 * @lc app=leetcode.cn id=2042 lang=java
 *
 * [2042] 检查句子中的数字是否递增
 */

// @lc code=start
class Solution {
    public boolean areNumbersAscending(String s) {
        // 分割字符串并找出数字部分
        // 跟上一个数字比较
        // 所有数字都是正数,所以前一个值可以初始化为0
        int pre = 0, pos = 0;
        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos))) {
                int cur = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    cur = cur * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            } else {
                pos++;
            }
        }
        return true;
    }
}
// @lc code=end

