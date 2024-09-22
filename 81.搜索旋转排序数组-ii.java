/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        // 这道题跟 lc33 类似，区别就是这题元素可以重复
        // 导致的问题是，当 mid 跟 nums[l] 或者 nums[r] 相同时
        // 我们无法确定 mid 的具体位置，
        // 它可能在左边，从 nums[l] 到 mid 之间都是相同数字
        // 也可能在右边，到 nums[r] 之间数字都相同
        // 简单的方法就是，这种情况下，把 l 和 r 都往中间挪一位
        // 总会出现 mid 跟 l 和 r 不同，处于上升的坡上，
        // 此时就可以判断出它在左边还是右边了
        // 注意这里需要额外再判断下如果 nums[l] 或者 nums[r] 正好是 target，
        // 也要提前返回结果
        // 因为我们相当于是跳过了对 l 和 r 两个位置的判断

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 这里判断比 lc33 多判断下两个边界
            if (nums[mid] == target || nums[l] == target || nums[r] == target) {
                return true;
            } else if (nums[mid] > nums[l]) {
                // mid 在分割的左半边
                // 当 target 比 mid 小的时候它在左区间
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l]) {
                // mid 在分割的右半边
                // target 比 mid 大的时候它在右区间
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // 这里是 mid 刚好在水平线上，
                // 要么在左边跟 l 相同，要么在右边跟 r 相同，
                // 让两边往中间缩，总会出现 mid 跟 l 和 r 不同
                l++;
                r--;
            }
        }

        return false;
    }
}
// @lc code=end

