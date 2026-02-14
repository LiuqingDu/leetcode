/*
 * @lc app=leetcode.cn id=2932 lang=java
 *
 * [2932] 找出强数对的最大异或值 I
 */

// @lc code=start
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int x = nums[i];
                int y = nums[j];

                // 判断是否为强数对
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    max = Math.max(max, x ^ y);
                }
            }
        }

        return max;
    }
}
// @lc code=end

