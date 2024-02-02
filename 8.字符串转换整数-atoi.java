/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {

        int n = s.length();
        int ind = 0;

        while (ind < n && s.charAt(ind) == ' ') {
            ind++;
        }

        int sig = 1;
        if (ind < n && s.charAt(ind) == '+') {
            ind++;
        } else if (ind < n && s.charAt(ind) == '-') {
            sig = -1;
            ind++;
        }

        int res = 0;
        while (ind < n && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
            int dig = s.charAt(ind) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && dig > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && dig > - (Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sig * dig;
            ind++;
        }

        return res;

    }
}
// @lc code=end

