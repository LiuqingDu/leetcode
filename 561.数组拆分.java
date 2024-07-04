/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        // 很明显，排序后两两成对，奇数位置的是小值，它们的和就是最大的小值
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }
}
// @lc code=end

