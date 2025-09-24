/*
 * @lc app=leetcode.cn id=2264 lang=java
 *
 * [2264] 字符串中最大的 3 位相同数字
 */

// @lc code=start
class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String res = "";
        for (int i = 0; i < n - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String current = num.substring(i, i + 3);
                if (res.compareTo(current) < 0) {
                    res = current;
                }
            }
        }
        return res;
    }
}
// @lc code=end

