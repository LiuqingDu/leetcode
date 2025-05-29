/*
 * @lc app=leetcode.cn id=1827 lang=java
 *
 * [1827] 最少操作使数组递增
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        // 就是如果当前数字不大于前一个,就把当前数字改为前一个+1
        // 然后累计此次增加的差值
        int res = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
// @lc code=end

