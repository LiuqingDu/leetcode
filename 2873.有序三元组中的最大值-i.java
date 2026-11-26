/*
 * @lc app=leetcode.cn id=2873 lang=java
 *
 * [2873] 有序三元组中的最大值 I
 */

// @lc code=start
class Solution {
    public long maximumTripletValue(int[] nums) {
        
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return res;

    }
}
// @lc code=end

