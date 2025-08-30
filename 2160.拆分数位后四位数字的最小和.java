/*
 * @lc app=leetcode.cn id=2160 lang=java
 *
 * [2160] 拆分数位后四位数字的最小和
 */

// @lc code=start
class Solution {
    public int minimumSum(int num) {
        // 明显组成两个两位数,且最小的两个数字作为它们的十位数
        // 是最小的
        int[] digits = new int[4];
        for (int i = 3; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);
        return (digits[0] + digits[1]) * 10 + (digits[2] + digits[3]);
    }
}
// @lc code=end

