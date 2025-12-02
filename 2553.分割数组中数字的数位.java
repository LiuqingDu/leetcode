/*
 * @lc app=leetcode.cn id=2553 lang=java
 *
 * [2553] 分割数组中数字的数位
 */

// @lc code=start
class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int n = sb.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = sb.charAt(i) - '0';
        }
        return result;
    }
}
// @lc code=end

