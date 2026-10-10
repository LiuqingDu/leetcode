/*
 * @lc app=leetcode.cn id=1509 lang=java
 *
 * [1509] 三次操作后最大值与最小值的最小差
 */

// @lc code=start
class Solution {
    public int minDifference(int[] nums) {
        
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;

    }
}
// @lc code=end

