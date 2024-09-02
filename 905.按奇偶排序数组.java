/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] % 2 == 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
// @lc code=end

