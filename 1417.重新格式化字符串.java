/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        // 双指针,先判断数字和字母有多少个,能否满足条件
        // 然后再双指针,分别指向最终字符串的奇数位和偶数位,分别填充数字和字母

        int num1 = 0, num2 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num1++;
            } else {
                num2++;
            }
        }
        if (Math.abs(num1 - num2) > 1) {
            return "";
        }
        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[num1] = c;
                num1 += 2;
            } else {
                chars[num2] = c;
                num2 += 2;
            }
        }
        return new String(chars);
    }
}
// @lc code=end

