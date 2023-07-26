/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;
        // 指针不能相交，但可以相等，相等说明区间只剩一个数字了
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果中间比目标值小，说明目标值在右边，左指针从右边第一个开始
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 如果中间比目标值大，说明目标值在左边，右指针从左边第一个开始
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 如果相等，因为是找左边距，所以让左指针不动，右指针往左边缩
                right = mid - 1;
            }
        }
        // 判断一下是否超过边界了
        if (left < 0 || left > nums.length - 1) {
            return -1;
        }
        // 判断一下是不是找到目标值了，有可能目标值不存在
        return nums[left] == target ? left : -1;
    
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || right > nums.length - 1) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    
    }
}
// @lc code=end

