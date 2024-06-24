/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        boolean flag = num < 0;
        if (flag) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 7);
            num /= 7;
        } while (num != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();
    }
}
// @lc code=end

