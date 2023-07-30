/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    // 迭代二分查找

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right) {
            mid = left + ((right - left)>>1);
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

