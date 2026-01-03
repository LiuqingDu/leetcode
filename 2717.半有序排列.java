/*
 * @lc app=leetcode.cn id=2717 lang=java
 *
 * [2717] 半有序排列
 */

// @lc code=start
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                first = i;
            } else if (nums[i] == n) {
                last = i;
            }
        }

        if (last > first) {
            return first + (n - 1 - last);
        } else {
            return first + (n - 1 - last) - 1;
        }
    }
}
// @lc code=end

