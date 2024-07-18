/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double ave = 0;
        double res = Double.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                if (i == k - 1) {
                    ave = sum / k;
                    res = ave;
                }
            } else {
                sum -= nums[i - k];
                sum += nums[i];
                ave = sum / k;
                res = Math.max(res, ave);
            }
        }
        return res;
    }
}
// @lc code=end

