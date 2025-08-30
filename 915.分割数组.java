/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] nums) {
        // 假设先找到一个点记为left,这个点分割数组为两部分
        // 记左侧最大值为leftMax
        // 如果右边所有元素都大于leftMax,则left分割是有效的
        // 如果在右侧找到一个点i,使得nums[i]<leftMax
        // 那么左半部分就需要把nums[i]包含进去,才能使得左边的小于等于右边
        // 并且在包含进去的时候,因为新包含了一部分元素进来,
        // 那么leftMax也需要更新了
        // 也就要求在右边寻找点i的过程中也要记录过程中的最大值
        // 一旦需要把新的i包含进来,就把leftMax更新为当前的最大值

        int n = nums.length;
        int left = 0;
        int leftMax = nums[0];
        int curMax = nums[0];
        // 因为必定可以分割,那么右边至少有一个数,所以右边<n-1即可
        for (int i = 1; i < n - 1; i++) {
            // 随时更新最大值,以备后用
            curMax = Math.max(curMax, nums[i]);
            // 如果在右侧找到一个点i,使得nums[i]<leftMax
            if (nums[i] < leftMax) {
                // 那么就需要把nums[i]包含进去
                left = i;
                // 同时要更新左区间的最大值
                leftMax = curMax;
            }
        }
        return left + 1;
    }
}
// @lc code=end

