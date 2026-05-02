/*
 * @lc app=leetcode.cn id=3079 lang=java
 *
 * [3079] 求出加密整数的和
 */

// @lc code=start
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int maxDigit = 0;
            int temp = num;

            // 1. 找最大数位
            while (temp > 0) {
                maxDigit = Math.max(maxDigit, temp % 10);
                temp /= 10;
            }

            // 2. 构造加密后的数
            int encrypted = 0;
            temp = num;

            while (temp > 0) {
                encrypted = encrypted * 10 + maxDigit;
                temp /= 10;
            }

            // 3. 加入总和
            sum += encrypted;
        }

        return sum;
    }
}
// @lc code=end

