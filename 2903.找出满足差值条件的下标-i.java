/*
 * @lc app=leetcode.cn id=2903 lang=java
 *
 * [2903] 找出满足差值条件的下标 I
 */

// @lc code=start
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j - i >= indexDifference && Math.abs(nums[j] - nums[i]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

