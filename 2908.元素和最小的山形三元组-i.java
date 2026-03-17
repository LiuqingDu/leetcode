/*
 * @lc app=leetcode.cn id=2908 lang=java
 *
 * [2908] 元素和最小的山形三元组 I
 */

// @lc code=start
class Solution {
    public int minimumSum(int[] nums) {
        
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        // 枚举中间点 j
        for (int j = 1; j < n - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            // 找左边最小且小于 nums[j]
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    leftMin = Math.min(leftMin, nums[i]);
                }
            }

            // 找右边最小且小于 nums[j]
            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    rightMin = Math.min(rightMin, nums[k]);
                }
            }

            // 如果左右都存在
            if (leftMin != Integer.MAX_VALUE && rightMin != Integer.MAX_VALUE) {
                res = Math.min(res, leftMin + nums[j] + rightMin);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

