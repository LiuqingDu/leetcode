/*
 * @lc app=leetcode.cn id=1869 lang=java
 *
 * [1869] 哪种连续子字符串更长
 */

// @lc code=start
class Solution {
    public boolean checkZeroOnes(String s) {
        int max0 = 0, max1 = 0;
        int count0 = 0, count1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
                count0 = 0;
                max1 = Math.max(max1, count1);
            } else {
                count0++;
                count1 = 0;
                max0 = Math.max(max0, count0);
            }
        }

        return max1 > max0;
    }
}
// @lc code=end

