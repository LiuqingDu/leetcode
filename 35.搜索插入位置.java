/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 双指针
        // 找左指针
        // 如果target 不存在，因为结束循环条件是指针相交，
        // 找左指针的话，则 left 刚好在比目标值大一点的位置上
        // 原理：
        // 如果没有找到 target，那么最后肯定是l在右边,r在左边
        // 此时分为两种情况：
        // 1. l从左边通过mid+1到右边的，说明 mid 小于 target，
        //    需要插到 mid 右边也就是 mid+1 的位置，也就是 l
        // 2. r 从右边通过 mid-1 到左边的，说明 mid 大于 target，
        //    需要插到 mid 的位置，此时 r 在 mid 左边一位，
        //    且 r 在 l 左边，说明 mid=l，那么 l 也是目标位置

        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return left;
    }
}
// @lc code=end

