/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 != 0) {
                j += 2;
            }

            if (i < n && j < n) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        return nums;
    }
}
// @lc code=end

